package app.emode.controller;

import java.util.List;
import java.util.Optional;

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

import app.emode.entities.Atelier;
import app.emode.service.AtelierService;


@RestController
@CrossOrigin("*")
public class AtelierController {

	@Autowired
	AtelierService service;

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
			_atelier.setLogo_atelier(atelier.getLogo_atelier());
			_atelier.setLatitude_atelier(atelier.getLatitude_atelier());
			_atelier.setLongitude_atelier(atelier.getLongitude_atelier());
			return new ResponseEntity<>(service.update(_atelier), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
