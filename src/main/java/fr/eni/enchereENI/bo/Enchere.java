package fr.eni.enchereENI.bo;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enchere {
	
	private int noEnchere;
	private LocalDateTime dateEnchere;
	private float montantEnchere;
	private Article articles;
	private User encherisseur;
	public Enchere(int noEnchere, LocalDateTime dateEnchere, float montantEnchere, Article articles, User encherisseur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articles = articles;
		this.encherisseur = encherisseur;
	}
	public Enchere() {
		super();
	}
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", articles=" + articles + ", encherisseur=" + encherisseur + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(articles, dateEnchere, encherisseur, montantEnchere, noEnchere);
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
		return Objects.equals(articles, other.articles) && Objects.equals(dateEnchere, other.dateEnchere)
				&& Objects.equals(encherisseur, other.encherisseur)
				&& Float.floatToIntBits(montantEnchere) == Float.floatToIntBits(other.montantEnchere)
				&& noEnchere == other.noEnchere;
	}
	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public float getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(float montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public Article getArticles() {
		return articles;
	}
	public void setArticles(Article articles) {
		this.articles = articles;
	}
	public User getEncherisseur() {
		return encherisseur;
	}
	public void setEncherisseur(User encherisseur) {
		this.encherisseur = encherisseur;
	}
	
	
	
	


}
