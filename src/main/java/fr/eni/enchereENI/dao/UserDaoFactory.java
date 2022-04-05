package fr.eni.enchereENI.dao;

import fr.eni.enchereENI.dao.impl.UserDaoImpl;

public class UserDaoFactory {
	
	public static UserDao getDao() {
		return new UserDaoImpl();
	}
}
