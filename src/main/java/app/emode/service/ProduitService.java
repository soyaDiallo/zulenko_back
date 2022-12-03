package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Atelier;
import app.emode.entities.Collection;
import app.emode.entities.Produit;
import app.emode.repository.ProduitRepository;
import app.emode.repository.ProduitRepository;

@Service
public class ProduitService {
	
	@Autowired
	ProduitRepository repository;

	public Produit create(Produit Produit) {
		return repository.save(Produit);
	}

	public List<Produit> getAll() {
		return repository.findAll();
	}

	public Optional<Produit> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Produit update(Produit Produit) {
		return repository.save(Produit);
	}
	
	public List<Produit> findByAtelier(Atelier atelier)
	{
		return repository.findByAtelier(atelier);
	}
	
	public List<Produit> findByCollection(Collection collection)
	{
		return repository.findByCollection(collection);
	}


}
