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

import app.emode.entities.Client;

import app.emode.service.ClientService;

@RestController
@CrossOrigin("*")
public class ClientController {

	@Autowired
	ClientService service;

	@GetMapping("/clients")
	List<Client> getALL() {
		return service.getAll();
	}

	@GetMapping("/clients/{id}")
	public Optional<Client> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/clients")
	public Client create(@RequestBody Client Client) {
		return service.create(Client);
	}

	@DeleteMapping("/clients/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> update(@PathVariable int id, @RequestBody Client client) {
		Optional<Client> a = service.getById(id);
		if (a.isPresent()) {
			Client _client = a.get();
			_client.setAdresse_client(client.getAdresse_client());
			_client.setNom_client(client.getNom_client());
			_client.setEmail_client(client.getEmail_client());
			_client.setImage_client(client.getImage_client());
			_client.setPrenom_client(client.getPrenom_client());
			_client.setTel_client(client.getTel_client());
			return new ResponseEntity<>(service.update(_client), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
