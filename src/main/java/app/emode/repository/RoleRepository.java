package app.emode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.emode.entities.ERole;
import app.emode.entities.Role;



public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(ERole name);
}
