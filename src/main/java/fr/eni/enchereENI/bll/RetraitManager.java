package fr.eni.enchereENI.bll;

import java.sql.SQLException;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.RetraitDao;

public class RetraitManager {
	public static boolean validateRetrait(String rue, String cp, String ville) {
		boolean isValid = true;

		if (rue == null || rue.isEmpty()) {
			isValid = false;
		}
		if (cp == null || cp.isEmpty()) {
			isValid = false;
		}
		if (ville == null || ville.isEmpty()) {
			isValid = false;
		}
		return isValid;
	}

	public static void addRetrait(int id, String rue, String cp, String ville) {
		RetraitDao retraitDao = DaoFactory.getRetraitDao();
		Retrait retraitAAjouter = new Retrait();
		ArticleManager articleManager = new ArticleManager();

		Article article = articleManager.getById(id);
		if (validateRetrait(rue, cp, ville)) {
			retraitAAjouter.setArticle(article);
			retraitAAjouter.setCp(cp);
			retraitAAjouter.setRue(rue);
			retraitAAjouter.setVille(ville);
			try {
				retraitDao.save(retraitAAjouter);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
