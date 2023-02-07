package app.emode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Atelier;
import app.emode.entities.Collection;
import app.emode.entities.Produit;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {
	
	List<Collection> findByAtelier(Atelier atelier);

}
