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
import app.emode.entities.ERole;
import app.emode.entities.Image;
import app.emode.entities.Produit;
import app.emode.entities.Role;
import app.emode.entities.User;
import app.emode.repository.RoleRepository;
import app.emode.service.AtelierService;
import app.emode.service.CollectionService;
import app.emode.service.ImageService;
import app.emode.service.ProduitService;
import app.emode.service.UserService;

@RestController
@CrossOrigin("*")
public class ProduitController {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ProduitService service;

	@Autowired
	ServletContext context;

	@Autowired
	AtelierService atelierService;

	@Autowired
	CollectionService collectionService;

	@Autowired
	ImageService imageService;
	
	@Autowired
	UserService userService;

	@GetMapping("/role")
	public Role getRole() {
		Role role = new Role();
		role.setName(ERole.ROLE_TAILLEUR);
		return roleRepository.save(role);
	}

	@GetMapping("/produits")
	List<Produit> getALL() {
		return service.getAll();
	}

	@GetMapping("/produits/{id}")
	public Optional<Produit> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@GetMapping("/produits/ateliers/{id}")
	public List<Produit> getByAtelier(@PathVariable int id) {
		Optional<Atelier> atelier = atelierService.getById(id);
		return service.findByAtelier(atelier.get());
	}

	@GetMapping("/produits/collections/{id}")
	public List<Produit> getByCollection(@PathVariable int id) {
		Optional<Collection> collection = collectionService.getById(id);
		return service.findByCollection(collection.get());
	}

	@PostMapping("/produits")
	public Produit create(@RequestBody Produit Produit) {
		return service.create(Produit);
	}

	@DeleteMapping("/produits/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/produits/{id}")
	public ResponseEntity<Produit> update(@PathVariable int id, @RequestBody Produit produit) {
		Optional<Produit> a = service.getById(id);
		if (a.isPresent()) {
			Produit _produit = a.get();
			_produit.setDesignation(produit.getDesignation());
			_produit.setPrix_produit(produit.getPrix_produit());
			return new ResponseEntity<>(service.update(_produit), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/ImgProduit/{id}")
	public byte[] getPhoto(@PathVariable("id") int id) throws Exception {
		Optional<Produit> produit = service.getById(id);
		List<Image> images = imageService.findByProduit(produit.get());
		for (Image img : images) {
			return Files.readAllBytes(Paths.get(context.getRealPath("/Images/") + img.getUrl_image()));
		}
		return null;

	}

	@PostMapping("/produits2")
	ResponseEntity<Produit> addProduit(@RequestParam("produit") String produit,
			@RequestParam("file") List<MultipartFile> file) throws JsonMappingException, JsonProcessingException {
		if (produit != null) {
			List<Image> images = new ArrayList<>();
			JSONObject json = new JSONObject(produit);
			System.out.println(json);

			// atelier
			Optional<Atelier> atelier = atelierService.getById(json.getInt("atelier"));

			// collection
			Optional<Collection> collection = collectionService.getById(json.getInt("collection"));

			// client
			Optional<User> client = userService.getUserById(json.getInt("client"));


			// produit
			java.util.Date date = new java.util.Date();
			Produit p = new Produit();
			p.setPrix_produit(json.getFloat("prix_produit"));
			p.setDesignation(json.getString("designation").toString());
			p.setDate_produit(date);
			p.setAtelier(atelier.get());
			p.setCollection(collection.get());
			p.setClient(client.get());

			service.create(p);

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
				image.setProduit(p);
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

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
