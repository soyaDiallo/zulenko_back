package app.emode.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Produit 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_produit;
	private String designation;
	private Date date_produit;
	
	@ManyToOne
	Atelier atelier;
	
	@ManyToOne
	Collection collection;
	
	@ManyToOne
	User client;
	



	public Produit(int id_produit, String designation, Date date_produit, Atelier atelier, Collection collection,
			User client) {
		super();
		this.id_produit = id_produit;
		this.designation = designation;
		this.date_produit = date_produit;
		this.atelier = atelier;
		this.collection = collection;
		this.client = client;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Date getDate_produit() {
		return date_produit;
	}

	public void setDate_produit(Date date_produit) {
		this.date_produit = date_produit;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}


	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	
	
	
}
