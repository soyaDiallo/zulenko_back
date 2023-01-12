package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Mesure;
import app.emode.entities.User;
import app.emode.repository.MesureRepository;
import app.emode.repository.MesureRepository;

@Service
public class MesureService {
	
	@Autowired
	MesureRepository repository;

	public Mesure create(Mesure Mesure) {
		return repository.save(Mesure);
	}

	public List<Mesure> getAll() {
		return repository.findAll();
	}

	public Optional<Mesure> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Mesure update(Mesure Mesure) {
		return repository.save(Mesure);
	}
	
	public Mesure findByClient(User client)
	{
		return repository.findByClient(client);
	}


}
