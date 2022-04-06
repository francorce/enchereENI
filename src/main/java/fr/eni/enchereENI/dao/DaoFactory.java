package fr.eni.enchereENI.dao;

import fr.eni.enchereENI.dao.impl.UserDaoImpl;

public class DaoFactory {
	
	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
