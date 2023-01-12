package app.emode.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.emode.entities.ERole;
import app.emode.entities.Role;
import app.emode.entities.User;
import app.emode.repository.RoleRepository;
import app.emode.service.UserService;



@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;



	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getAllUser();
	}


	@GetMapping("/users/{id}")
	public Optional<User> getUserByID(@PathVariable int id) {
		return service.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
	}

	// ajout du vendeur
	@PostMapping("/users")
	public User addclient(@RequestBody User user) {
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_CLIENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setPass(encoder.encode("12345678"));
		user.setUsername(user.getUsername());
		return service.addUser(user);
	}

	// ajout admin
	@PostMapping("/users/admin")
	public User addAdmin(@RequestBody User user) {
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setPass(encoder.encode("12345678"));
		user.setUsername("admin");
		user.setAdresse("jere");
		user.setEmail("admin@gmail.com");
		user.setNom("admin");
		user.setPrenom("admin");
		user.setTel("75484570");
		return service.addUser(user);
	}

	// ajout du livreur
	@PostMapping("/users/tailleur")
	public User addTailleur(@RequestBody User user) {
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_TAILLEUR)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setPass(encoder.encode("12345678"));
		user.setUsername(user.getUsername());
		return service.addUser(user);
	}

	@PutMapping("/users/{id}")
	ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
		Optional<User> _user = service.getUserById(id);
		if (_user.isPresent()) {
			User u = _user.get();
			u.setAdresse(user.getAdresse());
			u.setEmail(user.getEmail());
			u.setNom(user.getNom());
			u.setPrenom(user.getPrenom());
			u.setTel(user.getTel());
			u.setUsername(user.getUsername());
//			u.setPass(encoder.encode(user.getPass()));
			return new ResponseEntity<>(service.addUser(u), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/users/pass/{id}")
	ResponseEntity<User> updat(@RequestBody User user, @PathVariable int id) {
		Optional<User> _user = service.getUserById(id);
		if (_user.isPresent()) {
			User u = _user.get();
			u.setPass(encoder.encode(user.getPass()));
			return new ResponseEntity<>(service.addUser(u), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
