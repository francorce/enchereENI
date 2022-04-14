package fr.eni.enchereENI.bll;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.EnchereDao;

public class EnchereManager {
	private static EnchereDao enchereDao = DaoFactory.getEnchereDao();
	
	
	public List<Enchere> getByArticleAndUserId(int articleId, int userId){
		List<Enchere> listeEnchere = new ArrayList<Enchere>();
		try {
			listeEnchere = enchereDao.getByArticleAndUserId(articleId, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEnchere;
	}
	
	public List<Enchere> getAll() {
		List<Enchere> listeEnchere = new ArrayList();
		
		try {
			listeEnchere = enchereDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEnchere;
	}

	public List<Enchere> getByUserId(int userId) {
		List<Enchere> listeEnchere = new ArrayList();
		try {
			listeEnchere = enchereDao.getByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEnchere;
	}

	public List<Enchere> getByArticleId(int userId) {
		List<Enchere> listeEnchere = new ArrayList();
		try {
			listeEnchere = enchereDao.getByArticleId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEnchere;
	}

	public boolean encherir(String montantEnchereString, String numArticleString, User user) {
		boolean isOk = false;

		ArticleManager articleManager = new ArticleManager();
		UserManager userManager = new UserManager();

		int montantEnchere = 0;
		if (montantEnchereString != null) {
			montantEnchere = Integer.parseInt(montantEnchereString);
		}
		int numArticle = 0;
		if (numArticleString != null) {
			numArticle = Integer.parseInt(numArticleString);
		}
		Article article = articleManager.getById(numArticle);

		Enchere enchere = null;
		LocalDateTime now = LocalDateTime.now();
		EnchereDao enchereDao = DaoFactory.getEnchereDao();
		int prixVenteInitial = article.getPrixVente();

		// le vendeur ne peux pas enchérir a son enchère
		if (!article.getVendeur().equals(user)) {
			// check si le montant est supérieur au prix vente
			if (article.getPrixVente() < montantEnchere) {
				// check si la date est ok
				if (article.getDebutEnchere().isBefore(now) && article.getFinEnchere().isAfter(now)) {
					// check si l'utilisateur a assez de crédit
					if (user.getCredit() >= montantEnchere) {
						// si tout est ok on crée l'enchere
						enchere = new Enchere();
						enchere.setArticles(article);
						enchere.setDateEnchere(now);
						enchere.setEncherisseur(user);
						enchere.setMontantEnchere(montantEnchere);
						// on save l'enchere
						try {
							// on update le prix de vente de l'article
							article.setPrixVente(montantEnchere);
							articleManager.updateArticle(article);
							// on debite le user
							user.setCredit(user.getCredit() - montantEnchere);

							// on retrouve l'enchere la plus elevé
							List<Enchere> listEnchere = enchereDao.getByArticleId(numArticle);
							int montantPlusHauteEnchere = 0;
							if (listEnchere.size() > 0) {
								for (Enchere enchereFromDB : listEnchere) {
									if (enchereFromDB.getMontantEnchere() > montantPlusHauteEnchere) {
										montantPlusHauteEnchere = (int) enchereFromDB.getMontantEnchere();
									}
								}
								User dernierEncherisseur = null;
								// on retrouve le user qui correspond a cette enchere et on le recrédite
								for (Enchere enchereFromDB : listEnchere) {
									if (enchereFromDB.getMontantEnchere() == montantPlusHauteEnchere) {
										dernierEncherisseur = enchereFromDB.getEncherisseur();
									}
								}
								dernierEncherisseur.setCredit(dernierEncherisseur.getCredit() + prixVenteInitial);
								userManager.update(dernierEncherisseur);
							}
							enchereDao.save(enchere);
							// on update le user
							userManager.update(user);
							isOk = true;
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return isOk;
	}

}
