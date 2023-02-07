package app.emode.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.emode.entities.Atelier;
import app.emode.entities.Collection;
import app.emode.entities.Image;
import app.emode.entities.Produit;
import app.emode.entities.User;
import app.emode.entities.Collection;
import app.emode.service.AtelierService;
import app.emode.service.CollectionService;
import app.emode.service.ImageService;
import app.emode.service.ProduitService;

@RestController
@CrossOrigin("*")
public class CollectionController {
	
	@Autowired
	CollectionService service;
	
	@Autowired
	AtelierService atelierService;
	
	@Autowired
	ImageService imageService;
	@Autowired
	ServletContext context;
	
	@GetMapping("/collections")
	List<Collection> getALL() {
		return service.getAll();
	}

	@GetMapping("/collections/{id}")
	public Optional<Collection> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping("/collections/ateliers/{id}")
	public List<Collection> getByAtelier(@PathVariable int id) {
		Optional<Atelier> atelier = atelierService.getById(id);
		return service.findByAtelier(atelier.get());
	}

	@PostMapping("/collections")
	public Collection create(@RequestBody Collection Collection) {
		return service.create(Collection);
	}

	@DeleteMapping("/collections/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/collections/{id}")
	public ResponseEntity<Collection> update(@PathVariable int id, @RequestBody Collection Collection) {
		Optional<Collection> a = service.getById(id);
		if (a.isPresent()) {
			Collection _Collection = a.get();
			_Collection.setNom_collection(Collection.getNom_collection());
			return new ResponseEntity<>(service.update(_Collection), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ImgCollection/{id}")
	public byte[] getPhoto(@PathVariable("id") int id) throws Exception {
		Optional<Collection> collection = service.getById(id);
		List<Image> images = imageService.findByCollection(collection.get());
		for (Image img : images) {
			return Files.readAllBytes(Paths.get(context.getRealPath("/Images/") + img.getUrl_image()));
		}
		return null;

	}
	@PostMapping("/collections2")
	ResponseEntity<Collection> add(@RequestParam("collection") String collection,
			@RequestParam("file") List<MultipartFile> file) throws JsonMappingException, JsonProcessingException {
		if (collection != null) {
			List<Image> images = new ArrayList<>();
			JSONObject json = new JSONObject(collection);
			System.out.println(json);

			// atelier
			Optional<Atelier> atelier = atelierService.getById(json.getInt("atelier"));

			// collection
			java.util.Date date = new java.util.Date();
			Collection c = new Collection();
			c.setNom_collection(json.getString("nom_collection"));
			c.setAtelier(atelier.get());
			
			service.create(c);

			boolean isExit = new File(context.getRealPath("/Images/")).exists();
			if (!isExit) {
				new File(context.getRealPath("/Images/")).mkdir();
				System.out.println("mk dir.............");
			}
			for (MultipartFile f : file) {
				System.out.println(f.getOriginalFilename());
				String filename = f.getOriginalFilename();
				String newFileName = FilenameUtils.getBaseName(filename) + "." + FilenameUtils.getExtension(filename);

				// image
				Image image = new Image();
				image.setUrl_image(newFileName);
				image.setCollection(c);
				imageService.create(image);
				images.add(image);
				File serverFile = new File(context.getRealPath("/Images/" + File.separator + newFileName));
				try {
					System.out.println("Image");
					FileUtils.writeByteArrayToFile(serverFile, f.getBytes());

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			return new ResponseEntity<>(c,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
