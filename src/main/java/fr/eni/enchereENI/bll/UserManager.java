package fr.eni.enchereENI.bll;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.UserDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class UserManager {

	private static UserDao userDao = DaoFactory.getUserDao();;
	
	
	public void update (User user) {
		try {
			userDao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public static User connectUser(String pseudoOuEmail, String password) {
		User user = null;

		Boolean useEmail = isValidEmailAddress(pseudoOuEmail);
		try {
			user = useEmail ? userDao.getByEmail(pseudoOuEmail, password)
					: userDao.getByPseudo(pseudoOuEmail, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public static User getUser(int noUtilisateur) {
		// TODO : à faire
		User user = null;
		try {
			user = userDao.get(noUtilisateur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO
		}
		return user;
	}

	public boolean supprimerUser(User user) {
		boolean hasEnchere = false;
		boolean hasArticle = false;
		boolean isDeleted = false;
		EnchereManager enchereManager = new EnchereManager();
		ArticleManager articleManager = new ArticleManager();
		List<Enchere> enchereUser = enchereManager.getByUserId(user.getNo_utilisateur());
		List<Article> articleUser = articleManager.getArticleByUserId(user.getNo_utilisateur());

		// check si il a des article en cours de vente
		LocalDateTime todaysDate = LocalDateTime.now();

		if (articleUser.size() > 0) {
			for (Article article : articleUser) {
				if (article.getFinEnchere().isAfter(todaysDate) || article.getDebutEnchere().isAfter(todaysDate)) {
					hasArticle = true;
				}
				
			}
		}

		if (enchereUser.size() > 0) {
			int offreMax = 0;
			for (Enchere enchere : enchereUser) {
				if(enchere.getMontantEnchere()>offreMax) {
					offreMax= (int) enchere.getMontantEnchere();
					if(enchere.getEncherisseur().equals(user)) {
						hasEnchere=true;
					}
				}
			}
		}

		if (hasEnchere == false & hasArticle == false) {
			try {
				userDao.delete(user);
				isDeleted = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isDeleted;
	}

}
