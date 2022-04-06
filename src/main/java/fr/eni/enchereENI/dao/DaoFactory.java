package fr.eni.enchereENI.dao;

import fr.eni.enchereENI.dao.impl.ArticleDaoImpl;
import fr.eni.enchereENI.dao.impl.UserDaoImpl;

public class DaoFactory {
	
	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
	public static ArticleDao getArticleDao() {
		return new ArticleDaoImpl();
	}
}
