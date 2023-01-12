package app.emode.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

 
@Entity
@Table
public class User  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	@NotBlank
	@Size(max = 20)
	private String username;
	@NotBlank
	@Size(max = 120)
	private String pass;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@ManyToMany
	private Set<Role> roles = new HashSet<>();

	@ManyToMany(mappedBy = "clients")
	Set<Atelier> ateliers;
	
	@ManyToOne
	Atelier atelier;

	public User(int id, String nom, String prenom, String adresse, String tel,
			@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String pass,
			@NotBlank @Size(max = 50) @Email String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.username = username;
		this.pass = pass;
		this.email = email;
	}
	
	


	public User(String nom, String prenom, String adresse, String tel, @NotBlank @Size(max = 20) String username,
			@NotBlank @Size(max = 120) String pass, @NotBlank @Size(max = 50) @Email String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.username = username;
		this.pass = pass;
		this.email = email;
	}




	public User(int id, String nom, String prenom, String adresse, String tel,
			@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String pass,
			@NotBlank @Size(max = 50) @Email String email, Set<Role> roles, Set<Atelier> ateliers, Atelier atelier) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.roles = roles;
		this.ateliers = ateliers;
		this.atelier = atelier;
	}




	public Set<Atelier> getAteliers() {
		return ateliers;
	}




	public void setAteliers(Set<Atelier> ateliers) {
		this.ateliers = ateliers;
	}




	public Atelier getAtelier() {
		return atelier;
	}




	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}




	public User() {
		super();
		//TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
