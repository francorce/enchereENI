package fr.eni.enchereENI.bll;

import java.sql.SQLException;
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
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.ArticleDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class ArticleManager {
	private static ArticleDao articleDao = DaoFactory.getArticleDao();
	
	

	public void remporterEnchere() {
		EnchereManager enchereManager = new EnchereManager();
		UserManager userManager = new UserManager();

		ArticleDao articleDao = DaoFactory.getArticleDao();
		List<Article> listArticleEnchereFini = new ArrayList<Article>();
		User gagnant = null;
		try {
			// on recupere les articles dont les encheres sont fini
			listArticleEnchereFini = articleDao.selectArticleEnchereFini();
			for (Article article : listArticleEnchereFini) {
				// on recupere les encheres pour chaque article
				List<Enchere> listeEnchere = enchereManager.getByArticleId(article.getNoArticle());
				int montantMax = 0;
				// on cherche l'enchere gagnante
				for (Enchere enchere : listeEnchere) {
					if (enchere.getMontantEnchere() > montantMax) {
						montantMax = (int) enchere.getMontantEnchere();
					}
				}
				// on cherche le gagnant
				for (Enchere enchere : listeEnchere) {
					if (enchere.getMontantEnchere() == montantMax && !article.isSold()) {
						gagnant = enchere.getEncherisseur();
						User vendeur = article.getVendeur();
						vendeur.setCredit(article.getVendeur().getCredit() + montantMax);
						userManager.update(vendeur);
						article.setSold(true);
						articleDao.updateStateArticle(article);
						System.out.println(gagnant);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Article> selectArticleEnchereFini() {
		ArticleDao articleDao = DaoFactory.getArticleDao();
		List<Article> listArticleEnchereFini = new ArrayList<Article>();
		try {
			listArticleEnchereFini = articleDao.selectArticleEnchereFini();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listArticleEnchereFini;
	}

	public void updateArticle(Article a) {
		try {
			articleDao.update(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Article getById(int id) {
		Article article = null;
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
			articleAAjouter.setSold(false);
			articleAAjouter.setVendeur(vendeur);
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

	public List<Article> getArticleByUserId(int userId) {
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
