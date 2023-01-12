package app.emode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Mesure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_mesure;
	private int epaule;
	private int poitrine;
	private int ceinture;
	private int fesse;
	private int longueur_pied;
	private int longueur_global;
	private int manche;
	private int manche_courte;
	private int tour_de_masse;
	private int longueur;
	private int cuisse;
	private int poignet;
	private int cou;
	private int tete;
	private int longueur_genou;

	@OneToOne
	User client;

	public Mesure(int id_mesure, int epaule, int poitrine, int ceinture, int fesse, int longueur_pied,
			int longueur_global, int manche, int manche_courte, int tour_de_masse, int longueur, int cuisse,
			int poignet, int cou, int tete, int longueur_genou, User client) {
		super();
		this.id_mesure = id_mesure;
		this.epaule = epaule;
		this.poitrine = poitrine;
		this.ceinture = ceinture;
		this.fesse = fesse;
		this.longueur_pied = longueur_pied;
		this.longueur_global = longueur_global;
		this.manche = manche;
		this.manche_courte = manche_courte;
		this.tour_de_masse = tour_de_masse;
		this.longueur = longueur;
		this.cuisse = cuisse;
		this.poignet = poignet;
		this.cou = cou;
		this.tete = tete;
		this.longueur_genou = longueur_genou;
		this.client = client;
	}

	public Mesure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_mesure() {
		return id_mesure;
	}

	public void setId_mesure(int id_mesure) {
		this.id_mesure = id_mesure;
	}

	public int getEpaule() {
		return epaule;
	}

	public void setEpaule(int epaule) {
		this.epaule = epaule;
	}

	public int getPoitrine() {
		return poitrine;
	}

	public void setPoitrine(int poitrine) {
		this.poitrine = poitrine;
	}

	public int getCeinture() {
		return ceinture;
	}

	public void setCeinture(int ceinture) {
		this.ceinture = ceinture;
	}

	public int getFesse() {
		return fesse;
	}

	public void setFesse(int fesse) {
		this.fesse = fesse;
	}

	public int getLongueur_pied() {
		return longueur_pied;
	}

	public void setLongueur_pied(int longueur_pied) {
		this.longueur_pied = longueur_pied;
	}

	public int getLongueur_global() {
		return longueur_global;
	}

	public void setLongueur_global(int longueur_global) {
		this.longueur_global = longueur_global;
	}

	public int getManche() {
		return manche;
	}

	public void setManche(int manche) {
		this.manche = manche;
	}

	public int getManche_courte() {
		return manche_courte;
	}

	public void setManche_courte(int manche_courte) {
		this.manche_courte = manche_courte;
	}

	public int getTour_de_masse() {
		return tour_de_masse;
	}

	public void setTour_de_masse(int tour_de_masse) {
		this.tour_de_masse = tour_de_masse;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getCuisse() {
		return cuisse;
	}

	public void setCuisse(int cuisse) {
		this.cuisse = cuisse;
	}

	public int getPoignet() {
		return poignet;
	}

	public void setPoignet(int poignet) {
		this.poignet = poignet;
	}

	public int getCou() {
		return cou;
	}

	public void setCou(int cou) {
		this.cou = cou;
	}

	public int getTete() {
		return tete;
	}

	public void setTete(int tete) {
		this.tete = tete;
	}

	public int getLongueur_genou() {
		return longueur_genou;
	}

	public void setLongueur_genou(int longueur_genou) {
		this.longueur_genou = longueur_genou;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

}
