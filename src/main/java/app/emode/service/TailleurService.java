package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Atelier;
import app.emode.entities.Tailleur;
import app.emode.repository.TailleurRepository;
import app.emode.repository.TailleurRepository;

@Service
public class TailleurService {
	
	@Autowired
	TailleurRepository repository;

	public Tailleur create(Tailleur Tailleur) {
		return repository.save(Tailleur);
	}

	public List<Tailleur> getAll() {
		return repository.findAll();
	}

	public Optional<Tailleur> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Tailleur update(Tailleur Tailleur) {
		return repository.save(Tailleur);
	}
	
	public List<Tailleur> findByAtelier(Atelier atelier)
	{
		return repository.findByAtelier(atelier);
	}


}
