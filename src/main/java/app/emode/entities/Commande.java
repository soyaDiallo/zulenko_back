package app.emode.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commande;
	private float prix_commande;
	private float avance_commande;
	private Date date_commande;
	private Date date_rdv;
	
	@ManyToOne
	Produit produit;
	
	@ManyToOne
	User client;
	
	@ManyToOne
	Atelier atelier;

	public Commande() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Commande(int id_commande, float prix_commande, float avance_commande, Date date_commande, Date date_rdv,
			Produit produit, User client, Atelier atelier) {
		super();
		this.id_commande = id_commande;
		this.prix_commande = prix_commande;
		this.avance_commande = avance_commande;
		this.date_commande = date_commande;
		this.date_rdv = date_rdv;
		this.produit = produit;
		this.client = client;
		this.atelier = atelier;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public float getPrix_commande() {
		return prix_commande;
	}

	public void setPrix_commande(float prix_commande) {
		this.prix_commande = prix_commande;
	}

	public float getAvance_commande() {
		return avance_commande;
	}

	public void setAvance_commande(float avance_commande) {
		this.avance_commande = avance_commande;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public Date getDate_rdv() {
		return date_rdv;
	}

	public void setDate_rdv(Date date_rdv) {
		this.date_rdv = date_rdv;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}
	
	

}
