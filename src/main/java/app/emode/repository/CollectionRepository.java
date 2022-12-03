package app.emode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.emode.entities.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {

}
