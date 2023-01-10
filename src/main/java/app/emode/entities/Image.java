package app.emode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_image;
	private String url_image;
	
	@ManyToOne
	Collection collection;
	
	@ManyToOne
	Produit produit;

	public Image() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Image(int id_image, String url_image, Collection collection, Produit produit) {
		super();
		this.id_image = id_image;
		this.url_image = url_image;
		this.collection = collection;
		this.produit = produit;
	}

	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	

}
