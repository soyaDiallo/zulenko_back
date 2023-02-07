package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Atelier;
import app.emode.entities.Collection;
import app.emode.entities.Commande;
import app.emode.entities.Produit;
import app.emode.entities.User;
import app.emode.repository.CommandeRepository;
import app.emode.repository.CommandeRepository;

@Service
public class CommandeService {
	
	@Autowired
	CommandeRepository repository;
	
	public Commande create(Commande Commande) {
		return repository.save(Commande);
	}

	public List<Commande> getAll() {
		return repository.findAll();
	}

	public Optional<Commande> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Commande update(Commande Commande) {
		return repository.save(Commande);
	}
	
	public List<Commande> findByProduit(Produit p) {
		return repository.findByProduit( p);
	}
	
	public List<Commande> findByClient(User p) {
		return repository.findByClient( p);
	}
	
	public List<Commande> findByAtelier(Atelier p) {
		return repository.findByAtelier( p);
	}

}
