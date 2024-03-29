package app.emode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Collection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_collection;
	private String nom_collection;

	@ManyToOne
	Atelier atelier;

	public Collection(int id_collection, String nom_collection, Atelier atelier) {
		super();
		this.id_collection = id_collection;
		this.nom_collection = nom_collection;
		this.atelier = atelier;
	}

	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_collection() {
		return id_collection;
	}

	public void setId_collection(int id_collection) {
		this.id_collection = id_collection;
	}

	public String getNom_collection() {
		return nom_collection;
	}

	public void setNom_collection(String nom_collection) {
		this.nom_collection = nom_collection;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}

}
