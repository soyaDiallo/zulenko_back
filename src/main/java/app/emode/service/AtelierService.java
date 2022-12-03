package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Atelier;
import app.emode.repository.AtelierRepository;

@Service
public class AtelierService {

	@Autowired
	AtelierRepository repository;

	public Atelier create(Atelier atelier) {
		return repository.save(atelier);
	}

	public List<Atelier> getAll() {
		return repository.findAll();
	}

	public Optional<Atelier> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Atelier update(Atelier atelier) {
		return repository.save(atelier);
	}

}
