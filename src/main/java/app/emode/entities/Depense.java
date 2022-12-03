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
public class Depense 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_depense;
	private String motif_depense;
	private float montant_depense;
	private Date date_depense;

	@ManyToOne
	Produit produit;
	
	@ManyToOne
	Atelier atelier;

	public Depense(int id_depense, String motif_depense, float montant_depense, Date date_depense, Produit produit,
			Atelier atelier) {
		super();
		this.id_depense = id_depense;
		this.motif_depense = motif_depense;
		this.montant_depense = montant_depense;
		this.date_depense = date_depense;
		this.produit = produit;
		this.atelier = atelier;
	}

	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_depense() {
		return id_depense;
	}

	public void setId_depense(int id_depense) {
		this.id_depense = id_depense;
	}

	public String getMotif_depense() {
		return motif_depense;
	}

	public void setMotif_depense(String motif_depense) {
		this.motif_depense = motif_depense;
	}

	public float getMontant_depense() {
		return montant_depense;
	}

	public void setMontant_depense(float montant_depense) {
		this.montant_depense = montant_depense;
	}

	public Date getDate_depense() {
		return date_depense;
	}

	public void setDate_depense(Date date_depense) {
		this.date_depense = date_depense;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}
	
	

}
