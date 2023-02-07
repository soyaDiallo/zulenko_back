package app.emode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Atelier;
import app.emode.entities.Commande;
import app.emode.entities.Produit;
import app.emode.entities.User;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	
	List<Commande> findByClient(User client);
	
	List<Commande> findByAtelier(Atelier atelier);
	
	List<Commande> findByProduit(Produit produit);

}
