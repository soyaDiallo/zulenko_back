package app.emode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.emode.entities.Collection;
import app.emode.entities.Image;
import app.emode.entities.Produit;
import app.emode.repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	ImageRepository repository;
	
	public Image create(Image Image) {
		return repository.save(Image);
	}

	public List<Image> getAll() {
		return repository.findAll();
	}

	public Optional<Image> getById(int id) {
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Image update(Image Image) {
		return repository.save(Image);
	}
	
	public List<Image> findByProduit(Produit p) {
		return repository.findByProduit( p);
	}
	
	public List<Image> findByCollection(Collection p) {
		return repository.findByCollection( p);
	}
}
