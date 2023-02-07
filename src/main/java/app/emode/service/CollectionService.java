package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Atelier;
import app.emode.entities.Collection;
import app.emode.entities.Produit;
import app.emode.repository.CollectionRepository;

@Service
public class CollectionService {

	@Autowired
	CollectionRepository repository;
	
	public Collection create(Collection Collection) {
		return repository.save(Collection);
	}

	public List<Collection> getAll() {
		return repository.findAll();
	}

	public Optional<Collection> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Collection update(Collection Collection) {
		return repository.save(Collection);
	}
	
	public List<Collection> findByAtelier(Atelier atelier)
	{
		return repository.findByAtelier(atelier);
	}
}
