package app.emode.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Atelier;
import app.emode.entities.Depense;
import app.emode.entities.Produit;



@Repository
public interface DepenseRepository extends JpaRepository<Depense, Integer> {

	List<Depense> findByAtelier(Atelier atelier);
	List<Depense> findByProduit(Produit produit);
}
