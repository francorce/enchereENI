package fr.eni.enchereENI.bll;

import java.sql.SQLException;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.UserDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class UserManager {

	private static UserDao userDao = DaoFactory.getUserDao();;

	
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
		//TODO : à faire
		User user=null;
		try {
			user = userDao.get(noUtilisateur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//TODO
		}
		return user;
	}

	
	public boolean supprimerUser(User user) {
		boolean hasEnchere = false;
		boolean isDeleted = false;
		EnchereManager enchereManager = new EnchereManager();
		List<Enchere> enchereUser = enchereManager.getByUserId(user.getNo_utilisateur());
		if(enchereUser.size()>0) {
			hasEnchere = true;
		}
		
		if(!hasEnchere) {
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
