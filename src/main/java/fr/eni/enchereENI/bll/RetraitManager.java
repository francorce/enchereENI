package fr.eni.enchereENI.bll;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.dao.ArticleDao;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.RetraitDao;

public class RetraitManager {
	public static Map<String, Boolean> validateRetrait(String rue, String cp, String ville) {
		Map<String, Boolean> hasErrors = new HashMap<String, Boolean>();

		if (rue == null || rue.isEmpty()) {
			hasErrors.put("rue", true);
		}
		if (cp == null || cp.isEmpty()) {
			hasErrors.put("cp", true);
		}
		if (ville == null || ville.isEmpty()) {
			hasErrors.put("ville", true);
		}
		return hasErrors;
	}

	public static Map<String, Boolean> addRetrait(int id, String rue, String cp, String ville) {
		RetraitDao retraitDao = DaoFactory.getRetraitDao();
		Retrait retraitAAjouter = new Retrait();
		ArticleManager articleManager = new ArticleManager();

		Article article = articleManager.getById(id);
		Map<String, Boolean> hasErrors = validateRetrait(rue, cp, ville);

		boolean hasError = false;
		Iterator it = hasErrors.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getValue() == (Boolean) true) {
				hasError = true;
			}
		}
		if (hasError) {
			return hasErrors;
		} else {
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
		
		return hasErrors;
	}
}
