package fr.eni.enchereENI.bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enchere {
	
	private int noEnchere;
	private Date dateEnchere;
	private float montantEnchere;
	private List<Article> articles = new ArrayList<Article>();
	private User encherisseur;
	
	
	
	public Enchere(int noEnchere, Date dateEnchere, float montantEnchere, List<Article> noArticle, User encherisseur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articles = noArticle;
		this.encherisseur = encherisseur;
	}
	
	public Enchere() {
		super();
	}

	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public float getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(float montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public List<Article> getNoArticle() {
		return articles;
	}
	public void setNoArticle(List<Article> noArticle) {
		this.articles = noArticle;
	}
	public User getNoUtilisateur() {
		return encherisseur;
	}
	public void setNoUtilisateur(User encherisseur) {
		this.encherisseur = encherisseur;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateEnchere, montantEnchere, articles, noEnchere, encherisseur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchere other = (Enchere) obj;
		return Objects.equals(dateEnchere, other.dateEnchere)
				&& Float.floatToIntBits(montantEnchere) == Float.floatToIntBits(other.montantEnchere)
				&& Objects.equals(articles, other.articles) && noEnchere == other.noEnchere
				&& encherisseur == other.encherisseur;
	}
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticle=" + articles + ", noUtilisateur=" + encherisseur + "]";
	}
	
	

}
