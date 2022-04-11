package fr.eni.enchereENI.bll;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

	public Map<String, Boolean> addArticle(String nom, String description, String categorieLibelle, String prixDepart,
			String debutEnchereString, String finEnchereString, User vendeur, String rue, String cp, String ville) {
		Article articleAAjouter = new Article();

		Map<String, Boolean> hasErrors = new HashMap<String, Boolean>();
		Map<String, Boolean> hasErrorsRetrait = new HashMap<String, Boolean>();

		if (nom != null && !nom.isEmpty()) {
			articleAAjouter.setNomArticle(nom);
		} else {
			hasErrors.put("nom", true);
		}

		if (description != null && !description.isEmpty()) {
			articleAAjouter.setDescription(description);
		} else {
			hasErrors.put("description", true);
		}
		if (categorieLibelle != null && !categorieLibelle.isEmpty()) {
			Categorie categorie = null;
			CategorieManager categorieManager = new CategorieManager();
			categorie = categorieManager.getByLibelle(categorieLibelle);
			articleAAjouter.setCategorie(categorie);
		} else {
			hasErrors.put("categorieLibelle", true);
		}

		if (prixDepart != null && !prixDepart.isEmpty() && isInteger(prixDepart)) {
			articleAAjouter.setPrixInitial(Integer.parseInt(prixDepart));
			articleAAjouter.setPrixVente(Integer.parseInt(prixDepart));
		} else {
			hasErrors.put("prixDepart", true);
		}

		if (finEnchereString != null && !finEnchereString.isEmpty() && debutEnchereString != null
				&& !debutEnchereString.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.FRANCE);
			LocalDateTime debutEnchere = LocalDateTime.parse(debutEnchereString, formatter);
			LocalDateTime finEnchere = LocalDateTime.parse(finEnchereString, formatter);

			if (validateDate(debutEnchere, finEnchere)) {
				articleAAjouter.setDebutEnchere(debutEnchere);
				articleAAjouter.setFinEnchere(finEnchere);
			} else {
				hasErrors.put("finEnchereString", true);
			}

		} else {
			hasErrors.put("finEnchereString", true);
		}

		hasErrorsRetrait = RetraitManager.validateRetrait(rue, cp, ville);
		hasErrors.putAll(hasErrorsRetrait);
		Iterator it = hasErrors.entrySet().iterator();
		boolean hasError = false;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getValue() == (Boolean) true) {
				hasError = true;
			}
		}

		if (hasError) {

			return hasErrors;
		} else {
			articleAAjouter.setVendeur(vendeur);
			ArticleDao articleDao = DaoFactory.getArticleDao();
			try {
				int id = articleDao.save(articleAAjouter);
				if (id != 0) {
					hasErrorsRetrait = RetraitManager.addRetrait(id, rue, cp, ville);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		hasErrors.putAll(hasErrorsRetrait);

		return hasErrors;
	}

	public boolean validateDate(LocalDateTime debutEnchere, LocalDateTime finEnchere) {
		boolean dateValid = true;
		long miliseconds = System.currentTimeMillis();
		LocalDateTime dateDuJour = LocalDateTime.now();

		if (dateDuJour.isAfter(debutEnchere) || dateDuJour.isEqual(debutEnchere)) {
			dateValid = false;
		}
		if (finEnchere == debutEnchere) {
			dateValid = false;
		}
		if (debutEnchere.isAfter(finEnchere)) {
			dateValid = false;
		}
		return dateValid;
	}

	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
	public List<Article> getArticleByUserId(int userId){
		ArticleDao articleDao = DaoFactory.getArticleDao();
		List<Article> listeArticle = new ArrayList<Article>();
		try {
			listeArticle = articleDao.getByVendorId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeArticle;
	}

}
