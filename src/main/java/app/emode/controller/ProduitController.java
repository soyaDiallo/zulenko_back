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
import app.emode.entities.Collection;
import app.emode.entities.Produit;
import app.emode.service.AtelierService;
import app.emode.service.CollectionService;
import app.emode.service.ProduitService;

@RestController
@CrossOrigin("*")
public class ProduitController {
	
	@Autowired
	ProduitService service;

	@Autowired
	AtelierService atelierService;
	
	@Autowired
	CollectionService collectionService;
	
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
			_produit.setImage_produit(produit.getImage_produit());
			_produit.setPrix_produit(produit.getPrix_produit());
			return new ResponseEntity<>(service.update(_produit), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
