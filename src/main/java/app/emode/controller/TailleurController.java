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
import org.springframework.web.bind.annotation.RestController;

import app.emode.entities.Atelier;
import app.emode.entities.Tailleur;
import app.emode.service.AtelierService;
import app.emode.service.TailleurService;

@RestController
@CrossOrigin("*")
public class TailleurController {

	@Autowired
	TailleurService service;
	
	@Autowired
	AtelierService atelierService;

	@GetMapping("/tailleurs")
	List<Tailleur> getALL() {
		return service.getAll();
	}

	@GetMapping("/tailleurs/{id}")
	public Optional<Tailleur> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping("/tailleurs/ateliers/{id}")
	public List<Tailleur> getByAtelier(@PathVariable int id) {
		Optional<Atelier> atelier = atelierService.getById(id);
		return service.findByAtelier(atelier.get());
	}

	@PostMapping("/tailleurs")
	public Tailleur create(@RequestBody Tailleur Tailleur) {
		return service.create(Tailleur);
	}

	@DeleteMapping("/tailleurs/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/tailleurs/{id}")
	public ResponseEntity<Tailleur> update(@PathVariable int id, @RequestBody Tailleur tailleur) {
		Optional<Tailleur> a = service.getById(id);
		if (a.isPresent()) {
			Tailleur _tailleur = a.get();
			_tailleur.setAdresse_tailleur(tailleur.getAdresse_tailleur());
			_tailleur.setEmail_tailleur(tailleur.getEmail_tailleur());
			_tailleur.setImage_tailleur(tailleur.getImage_tailleur());
			_tailleur.setNom_tailleur(tailleur.getNom_tailleur());
			_tailleur.setPrenom_tailleur(tailleur.getPrenom_tailleur());
			_tailleur.setTel_tailleur(tailleur.getTel_tailleur());
			return new ResponseEntity<>(service.update(_tailleur), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
