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

import app.emode.entities.Mesure;
import app.emode.entities.User;
import app.emode.service.MesureService;
import app.emode.service.UserService;

@RestController
@CrossOrigin("*")
public class MesureController {

	@Autowired
	MesureService service;

	@Autowired
	UserService clientService;

	@GetMapping("/mesures")
	List<Mesure> getALL() {
		return service.getAll();
	}

	@GetMapping("/mesures/{id}")
	public Optional<Mesure> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@GetMapping("/mesures/clients/{id}")
	public Mesure getByClient(@PathVariable int id) {
		Optional<User> client = clientService.getUserById(id);
		return service.findByClient(client.get());
	}

	@PostMapping("/mesures")
	public Mesure create(@RequestBody Mesure Mesure) {
		return service.create(Mesure);
	}

	@DeleteMapping("/mesures/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/mesures/{id}")
	public ResponseEntity<Mesure> update(@PathVariable int id, @RequestBody Mesure mesure) {
		Optional<Mesure> a = service.getById(id);
		if (a.isPresent()) {
			Mesure _mesure = a.get();
			_mesure.setCeinture(mesure.getCeinture());
			_mesure.setCou(mesure.getCou());
			_mesure.setCuisse(mesure.getCuisse());
			_mesure.setEpaule(mesure.getEpaule());
			_mesure.setFesse(mesure.getFesse());
			_mesure.setLongueur(mesure.getLongueur());
			_mesure.setLongueur_genou(mesure.getLongueur_genou());
			_mesure.setLongueur_global(mesure.getLongueur_global());
			_mesure.setLongueur_pied(mesure.getLongueur_pied());
			_mesure.setManche(mesure.getManche());
			_mesure.setManche_courte(mesure.getManche_courte());
			_mesure.setPoignet(mesure.getPoignet());
			_mesure.setPoitrine(mesure.getPoitrine());
			_mesure.setTete(mesure.getTete());
			_mesure.setTour_de_masse(mesure.getTour_de_masse());
			return new ResponseEntity<>(service.update(_mesure), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
