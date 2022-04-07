package fr.eni.enchereENI.bll;

import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dao.UserDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class UserManager {

	private static UserDao userDao;
	
	static  {
		userDao = DaoFactory.getUserDao();
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

		

}
