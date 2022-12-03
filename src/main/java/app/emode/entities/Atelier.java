package app.emode.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Atelier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_atelier;
	private String nom_atelier;
	private String logo_atelier;
	private String adresse_atelier;
	private float longitude_atelier;
	private float latitude_atelier;
	
	@ManyToMany
	@JoinTable(
			  joinColumns = @JoinColumn(name = "id_atelier"), 
			  inverseJoinColumns = @JoinColumn(name = "id_client"))
	Set<Client> clients;
	
	

	public Atelier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Atelier(int id_atelier, String nom_atelier, String logo_atelier, String adresse_atelier,
			float longitude_atelier, float latitude_atelier, Set<Client> clients) {
		super();
		this.id_atelier = id_atelier;
		this.nom_atelier = nom_atelier;
		this.logo_atelier = logo_atelier;
		this.adresse_atelier = adresse_atelier;
		this.longitude_atelier = longitude_atelier;
		this.latitude_atelier = latitude_atelier;
		this.clients = clients;
	}



	public int getId_atelier() {
		return id_atelier;
	}

	public void setId_atelier(int id_atelier) {
		this.id_atelier = id_atelier;
	}

	public String getNom_atelier() {
		return nom_atelier;
	}

	public void setNom_atelier(String nom_atelier) {
		this.nom_atelier = nom_atelier;
	}

	public String getLogo_atelier() {
		return logo_atelier;
	}

	public void setLogo_atelier(String logo_atelier) {
		this.logo_atelier = logo_atelier;
	}

	public String getAdresse_atelier() {
		return adresse_atelier;
	}

	public void setAdresse_atelier(String adresse_atelier) {
		this.adresse_atelier = adresse_atelier;
	}

	public float getLongitude_atelier() {
		return longitude_atelier;
	}

	public void setLongitude_atelier(float longitude_atelier) {
		this.longitude_atelier = longitude_atelier;
	}

	public float getLatitude_atelier() {
		return latitude_atelier;
	}

	public void setLatitude_atelier(float latitude_atelier) {
		this.latitude_atelier = latitude_atelier;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
	

}
