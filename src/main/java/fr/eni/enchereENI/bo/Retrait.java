package fr.eni.enchereENI.bo;

import java.util.Objects;

public class Retrait {
	private Article article;
	private String rue;
	private String cp;
	private String ville;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public int hashCode() {
		return Objects.hash(article, cp, rue, ville);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retrait other = (Retrait) obj;
		return Objects.equals(article, other.article) && Objects.equals(cp, other.cp) && Objects.equals(rue, other.rue)
				&& Objects.equals(ville, other.ville);
	}
	@Override
	public String toString() {
		return "Retrait [article=" + article + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + "]";
	}
	
	

}
