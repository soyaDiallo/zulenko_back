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
import app.emode.entities.Depense;
import app.emode.entities.Produit;
import app.emode.service.AtelierService;
import app.emode.service.DepenseService;
import app.emode.service.ProduitService;

@RestController
@CrossOrigin("*")
public class DepenseController {
	
	@Autowired
	DepenseService service;
	
	@Autowired
	AtelierService atelierService;
	
	@Autowired
	ProduitService produitService;

	@GetMapping("/depenses")
	List<Depense> getALL() {
		return service.getAll();
	}

	@GetMapping("/depenses/{id}")
	public Optional<Depense> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping("/depenses/ateliers/{id}")
	public List<Depense> getByAtelier(@PathVariable int id) {
		Optional<Atelier> atelier = atelierService.getById(id);
		return service.findByAtelier(atelier.get());
	}
	
	@GetMapping("/depenses/produits/{id}")
	public List<Depense> getByProduit(@PathVariable int id) {
		Optional<Produit> produit = produitService.getById(id);
		return service.findByProduit(produit.get());
	}

	@PostMapping("/depenses")
	public Depense create(@RequestBody Depense Depense) {
		return service.create(Depense);
	}

	@DeleteMapping("/depenses/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/depenses/{id}")
	public ResponseEntity<Depense> update(@PathVariable int id, @RequestBody Depense depense) {
		Optional<Depense> a = service.getById(id);
		if (a.isPresent()) {
			Depense _depense = a.get();
			_depense.setMontant_depense(depense.getMontant_depense());
			_depense.setMotif_depense(depense.getMotif_depense());
			return new ResponseEntity<>(service.update(_depense), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
