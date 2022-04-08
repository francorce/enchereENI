package fr.eni.enchereENI.bll;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.ArticleDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class ArticleManager {
	
	public Article getById(int id) {
		Article article = null;
		ArticleDao articleDao = DaoFactory.getArticleDao();
		try {
			article = articleDao.get(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}

	public List<Article> getAll() {
		List<Article> listeArticles = new ArrayList<Article>();
		ArticleDao articleDao = DaoFactory.getArticleDao();
		try {
			listeArticles = articleDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeArticles;
	}

	public boolean addArticle(String nom, String description, String categorieLibelle, String prixDepart,
			String debutEnchereString, String finEnchereString, User vendeur, String rue, String cp, String ville) {
		Article articleAAjouter = new Article();
		Boolean hasErrors = false;
		

		if (nom != null && !nom.isEmpty()) {
			articleAAjouter.setNomArticle(nom);
		} else {
			hasErrors = true;
		}

		if (description != null && !description.isEmpty()) {
			articleAAjouter.setDescription(description);
		} else {
			hasErrors = true;
		}
		if (categorieLibelle != null && !categorieLibelle.isEmpty()) {
			Categorie categorie = null;
			CategorieManager categorieManager = new CategorieManager();
			categorie = categorieManager.getByLibelle(categorieLibelle);
			articleAAjouter.setCategorie(categorie);
		} else {
			hasErrors = true;
		}

		if (prixDepart != null && !prixDepart.isEmpty()) {
			articleAAjouter.setPrixInitial(Integer.parseInt(prixDepart));
			articleAAjouter.setPrixVente(Integer.parseInt(prixDepart));
		} else {
			hasErrors = true;
		}

		if (finEnchereString != null && !finEnchereString.isEmpty() && debutEnchereString != null
				&& !debutEnchereString.isEmpty()) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
				Date debutEnchere = new java.sql.Date(formatter.parse(debutEnchereString).getTime());
				Date finEnchere = new java.sql.Date(formatter.parse(finEnchereString).getTime());
				if (validateDate(debutEnchere, finEnchere)) {
					articleAAjouter.setDebutEnchere(debutEnchere);
					articleAAjouter.setFinEnchere(finEnchere);
				} else {
					hasErrors = true;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				hasErrors = true;
			}		
		}
		
	
		
		if(!hasErrors) {
			articleAAjouter.setVendeur(vendeur);
			ArticleDao articleDao = DaoFactory.getArticleDao();
			try {
				int id = articleDao.save(articleAAjouter);
				if(id!=0) {
					RetraitManager.addRetrait(id, rue, cp, ville);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hasErrors;
	}

	public boolean validateDate(Date debutEnchere, Date finEnchere) {
		boolean dateValid = true;
		long miliseconds = System.currentTimeMillis();
		Date dateDuJour = new Date(miliseconds);

		if (dateDuJour.after(debutEnchere) || dateDuJour.equals(debutEnchere) ) {
			dateValid = false;
		}
		if (finEnchere == debutEnchere) {
			dateValid = false;
		}
		if (debutEnchere.after(finEnchere)) {
			dateValid = false;
		}
		return dateValid;
	}

}
