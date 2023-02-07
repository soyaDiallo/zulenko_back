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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.emode.entities.Atelier;
import app.emode.entities.Collection;
import app.emode.entities.Image;
import app.emode.service.AtelierService;

@RestController
@CrossOrigin("*")
public class AtelierController {

	@Autowired
	AtelierService service;

	@Autowired
	ServletContext context;

	@GetMapping("/ateliers")
	List<Atelier> getALL() {
		return service.getAll();
	}

	@GetMapping("/ateliers/{id}")
	public Optional<Atelier> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/ateliers")
	public Atelier create(@RequestBody Atelier atelier) {
		return service.create(atelier);
	}

	@DeleteMapping("/ateliers/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/ateliers/{id}")
	public ResponseEntity<Atelier> update(@PathVariable int id, @RequestBody Atelier atelier) {
		Optional<Atelier> a = service.getById(id);
		if (a.isPresent()) {
			Atelier _atelier = a.get();
			_atelier.setNom_atelier(atelier.getNom_atelier());
			_atelier.setAdresse_atelier(atelier.getAdresse_atelier());
			_atelier.setLatitude_atelier(atelier.getLatitude_atelier());
			_atelier.setLongitude_atelier(atelier.getLongitude_atelier());
			return new ResponseEntity<>(service.update(_atelier), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/ImgAtelier/{id}")
	public byte[] getPhoto(@PathVariable("id") int id) throws Exception {
		Optional<Atelier> atelier = service.getById(id);
		Atelier a = atelier.get();
		return Files.readAllBytes(Paths.get(context.getRealPath("/Images/") + a.getLogo_atelier()));

	}

	@PostMapping("/ateliers2")
	ResponseEntity<Atelier> add(@RequestParam("atelier") String collection, @RequestParam("file") MultipartFile file)
			throws JsonMappingException, JsonProcessingException {
		if (collection != null) {
			List<Image> images = new ArrayList<>();
			JSONObject json = new JSONObject(collection);
			System.out.println(json);

			// collection
			java.util.Date date = new java.util.Date();
			Atelier a = new Atelier();
			a.setAdresse_atelier(json.getString("adresse"));
			a.setLatitude_atelier(json.getFloat("latitude"));
			a.setLongitude_atelier(json.getFloat("longitude"));
			a.setNom_atelier(json.getString("nom"));

			boolean isExit = new File(context.getRealPath("/Images/")).exists();
			if (!isExit) {
				new File(context.getRealPath("/Images/")).mkdir();
				System.out.println("mk dir.............");
			}

			System.out.println(file.getOriginalFilename());
			String filename = file.getOriginalFilename();
			String newFileName = FilenameUtils.getBaseName(filename) + "." + FilenameUtils.getExtension(filename);

			File serverFile = new File(context.getRealPath("/Images/" + File.separator + newFileName));
			try {
				System.out.println("Image");
				FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
				a.setLogo_atelier(newFileName);
				service.create(a);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
