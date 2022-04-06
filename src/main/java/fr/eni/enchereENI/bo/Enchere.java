package fr.eni.enchereENI.bo;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Enchere {
	
	private int noEnchere;
	private Date dateEnchere;
	private float montantEnchere;
	private List<Integer> noArticle;
	private int noUtilisateur;
	
	
	
	public Enchere(int noEnchere, Date dateEnchere, float montantEnchere, List<Integer> noArticle, int noUtilisateur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.noUtilisateur = noUtilisateur;
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
	public List<Integer> getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(List<Integer> noArticle) {
		this.noArticle = noArticle;
	}
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateEnchere, montantEnchere, noArticle, noEnchere, noUtilisateur);
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
				&& Objects.equals(noArticle, other.noArticle) && noEnchere == other.noEnchere
				&& noUtilisateur == other.noUtilisateur;
	}
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticle=" + noArticle + ", noUtilisateur=" + noUtilisateur + "]";
	}
	
	

}
