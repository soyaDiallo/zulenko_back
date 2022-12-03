package app.emode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Client;
import app.emode.entities.Mesure;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
