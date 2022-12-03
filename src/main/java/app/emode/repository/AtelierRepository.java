package app.emode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Atelier;



@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Integer> {

}
