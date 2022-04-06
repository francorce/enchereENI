package fr.eni.enchereENI.bo;

import java.sql.Date;
import java.util.Objects;

public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private Date debutEnchere;
	private Date finEnchere;
	private float prixInitial;
	private float prixVente;
	private User vendeur;
	private Categorie categorie;
	
	
	public Article(int noArticle, String nomArticle, String description, Date debutEnchere, Date finEnchere,
			float prixInitial, float prixVente, User vendeur, Categorie categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}
	
	public Article() {
		super();
	}
	
	
	
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDebutEnchere() {
		return debutEnchere;
	}
	public void setDebutEnchere(Date debutEnchere) {
		this.debutEnchere = debutEnchere;
	}
	public Date getFinEnchere() {
		return finEnchere;
	}
	public void setFinEnchere(Date finEnchere) {
		this.finEnchere = finEnchere;
	}
	public float getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(float prixInitial) {
		this.prixInitial = prixInitial;
	}
	public float getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}
	public User getVendeur() {
		return vendeur;
	}
	public void setVendeur(User vendeur) {
		this.vendeur = vendeur;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categorie, debutEnchere, description, finEnchere, noArticle, nomArticle, prixInitial,
				prixVente, vendeur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(categorie, other.categorie) && Objects.equals(debutEnchere, other.debutEnchere)
				&& Objects.equals(description, other.description) && Objects.equals(finEnchere, other.finEnchere)
				&& noArticle == other.noArticle && Objects.equals(nomArticle, other.nomArticle)
				&& Float.floatToIntBits(prixInitial) == Float.floatToIntBits(other.prixInitial)
				&& Float.floatToIntBits(prixVente) == Float.floatToIntBits(other.prixVente)
				&& Objects.equals(vendeur, other.vendeur);
	}
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", debutEnchere=" + debutEnchere + ", finEnchere=" + finEnchere + ", prixInitial=" + prixInitial
				+ ", prixVente=" + prixVente + ", vendeur=" + vendeur + ", categorie=" + categorie + "]";
	}

	
	
	
}
