package app.emode.entities;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_client;
	private String nom_client;
	private String prenom_client;
	private String tel_client;
	private String email_client;
	private String adresse_client;
	private String image_client;
	
	
	
	@ManyToMany(mappedBy = "clients")
	Set<Atelier> ateliers;

	public Client(int id_client, String nom_client, String prenom_client, String tel_client, String email_client,
			String adresse_client, String image_client, Set<Atelier> ateliers) {
		super();
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.tel_client = tel_client;
		this.email_client = email_client;
		this.adresse_client = adresse_client;
		this.image_client = image_client;
		this.ateliers = ateliers;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public String getTel_client() {
		return tel_client;
	}

	public void setTel_client(String tel_client) {
		this.tel_client = tel_client;
	}

	public String getEmail_client() {
		return email_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}

	public String getAdresse_client() {
		return adresse_client;
	}

	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}

	public String getImage_client() {
		return image_client;
	}

	public void setImage_client(String image_client) {
		this.image_client = image_client;
	}


	public Set<Atelier> getAteliers() {
		return ateliers;
	}

	public void setAteliers(Set<Atelier> ateliers) {
		this.ateliers = ateliers;
	}
	
	

}
