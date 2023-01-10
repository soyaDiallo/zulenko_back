 package app.emode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Collection;
import app.emode.entities.Image;
import app.emode.entities.Produit;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

	List<Image> findByProduit(Produit produit);
	List<Image> findByCollection(Collection collection);
}
