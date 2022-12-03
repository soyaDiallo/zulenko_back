package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Atelier;
import app.emode.entities.Depense;
import app.emode.entities.Produit;
import app.emode.repository.DepenseRepository;
import app.emode.repository.DepenseRepository;

@Service
public class DepenseService {

	@Autowired
	DepenseRepository repository;

	public Depense create(Depense Depense) {
		return repository.save(Depense);
	}

	public List<Depense> getAll() {
		return repository.findAll();
	}

	public Optional<Depense> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Depense update(Depense Depense) {
		return repository.save(Depense);
	}

	public List<Depense> findByProduit(Produit produit) {
		return repository.findByProduit(produit);
	}

	public List<Depense> findByAtelier(Atelier atelier) {
		return repository.findByAtelier(atelier);
	}

}
