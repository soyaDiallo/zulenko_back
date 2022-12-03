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

import app.emode.entities.Collection;
import app.emode.entities.Collection;
import app.emode.service.CollectionService;

@RestController
@CrossOrigin("*")
public class CollectionController {
	
	@Autowired
	CollectionService service;
	
	@GetMapping("/collections")
	List<Collection> getALL() {
		return service.getAll();
	}

	@GetMapping("/collections/{id}")
	public Optional<Collection> getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping("/collections")
	public Collection create(@RequestBody Collection Collection) {
		return service.create(Collection);
	}

	@DeleteMapping("/collections/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PutMapping("/collections/{id}")
	public ResponseEntity<Collection> update(@PathVariable int id, @RequestBody Collection Collection) {
		Optional<Collection> a = service.getById(id);
		if (a.isPresent()) {
			Collection _Collection = a.get();
			_Collection.setNom_collection(Collection.getNom_collection());
			_Collection.setImage_collection(Collection.getImage_collection());
			return new ResponseEntity<>(service.update(_Collection), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
