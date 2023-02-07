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
import app.emode.entities.Commande;
import app.emode.entities.Depense;
import app.emode.entities.Produit;
import app.emode.entities.User;
import app.emode.service.AtelierService;
import app.emode.service.CommandeService;
import app.emode.service.ProduitService;
import app.emode.service.UserService;

@RestController
@CrossOrigin("*")
public class CommandeController {

	
	@Autowired
	CommandeService service;
	@Autowired
	AtelierService atelierService;
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	UserService userService;
	@GetMapping("/commandes")
	List<Commande> getALL() {
		return service.getAll();
	}
	
	@GetMapping("/commandes/ateliers/{id}")
	public List<Commande> getByAtelier(@PathVariable int id) {
		Optional<Atelier> atelier = atelierService.getById(id);
		return service.findByAtelier(atelier.get());
	}
	
	@GetMapping("/commandes/produits/{id}")
	public List<Commande> getByProduit(@PathVariable int id) {
		Optional<Produit> produit = produitService.getById(id);
		return service.findByProduit(produit.get());
	}
	
	@GetMapping("/commandes/users/{id}")
	public List<Commande> getByClient(@PathVariable int id) {
		Optional<User> user = userService.getUserById(id);
		return service.findByClient(user.get());
	}

	@GetMapping("/commandes/{id}")
	public Optional<Commande> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/commandes")
	public Commande create(@RequestBody Commande Commande) {
		return service.create(Commande);
	}

	@DeleteMapping("/commandes/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/commandes/{id}")
	public ResponseEntity<Commande> update(@PathVariable int id, @RequestBody Commande commande) {
		Optional<Commande> a = service.getById(id);
		if (a.isPresent()) {
			Commande c = a.get();
			c.setAtelier(commande.getAtelier());
			c.setAvance_commande(commande.getAvance_commande());
			c.setClient(commande.getClient());
			c.setDate_commande(commande.getDate_commande());
			c.setDate_rdv(commande.getDate_rdv());
			c.setPrix_commande(commande.getPrix_commande());
			c.setProduit(commande.getProduit());
			return new ResponseEntity<>(service.update(c), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
