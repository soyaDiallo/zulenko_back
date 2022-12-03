package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Client;
import app.emode.repository.ClientRepository;
import app.emode.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;

	public Client create(Client Client) {
		return repository.save(Client);
	}

	public List<Client> getAll() {
		return repository.findAll();
	}

	public Optional<Client> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Client update(Client Client) {
		return repository.save(Client);
	}


}
