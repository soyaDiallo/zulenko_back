package app.emode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tailleur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tailleur;
	private String nom_tailleur;
	private String prenom_tailleur;
	private String tel_tailleur;
	private String email_tailleur;
	private String adresse_tailleur;
	private String image_tailleur;

	@ManyToOne
	Atelier atelier;

	public Tailleur(int id_tailleur, String nom_tailleur, String prenom_tailleur, String tel_tailleur,
			String email_tailleur, String adresse_tailleur, String image_tailleur, Atelier atelier) {
		super();
		this.id_tailleur = id_tailleur;
		this.nom_tailleur = nom_tailleur;
		this.prenom_tailleur = prenom_tailleur;
		this.tel_tailleur = tel_tailleur;
		this.email_tailleur = email_tailleur;
		this.adresse_tailleur = adresse_tailleur;
		this.image_tailleur = image_tailleur;
		this.atelier = atelier;
	}

	public Tailleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_tailleur() {
		return id_tailleur;
	}

	public void setId_tailleur(int id_tailleur) {
		this.id_tailleur = id_tailleur;
	}

	public String getNom_tailleur() {
		return nom_tailleur;
	}

	public void setNom_tailleur(String nom_tailleur) {
		this.nom_tailleur = nom_tailleur;
	}

	public String getPrenom_tailleur() {
		return prenom_tailleur;
	}

	public void setPrenom_tailleur(String prenom_tailleur) {
		this.prenom_tailleur = prenom_tailleur;
	}

	public String getTel_tailleur() {
		return tel_tailleur;
	}

	public void setTel_tailleur(String tel_tailleur) {
		this.tel_tailleur = tel_tailleur;
	}

	public String getEmail_tailleur() {
		return email_tailleur;
	}

	public void setEmail_tailleur(String email_tailleur) {
		this.email_tailleur = email_tailleur;
	}

	public String getAdresse_tailleur() {
		return adresse_tailleur;
	}

	public void setAdresse_tailleur(String adresse_tailleur) {
		this.adresse_tailleur = adresse_tailleur;
	}

	public String getImage_tailleur() {
		return image_tailleur;
	}

	public void setImage_tailleur(String image_tailleur) {
		this.image_tailleur = image_tailleur;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}

}
