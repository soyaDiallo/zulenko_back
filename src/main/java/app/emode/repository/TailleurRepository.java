package app.emode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Atelier;
import app.emode.entities.Tailleur;


@Repository
public interface TailleurRepository extends JpaRepository<Tailleur, Integer> {

	List<Tailleur> findByAtelier(Atelier atelier);
}
