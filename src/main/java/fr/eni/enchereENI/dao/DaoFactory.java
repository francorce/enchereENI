package fr.eni.enchereENI.dao;

import fr.eni.enchereENI.dao.impl.ArticleDaoImpl;
import fr.eni.enchereENI.dao.impl.CategorieDaoImpl;
import fr.eni.enchereENI.dao.impl.EnchereDaoImpl;
import fr.eni.enchereENI.dao.impl.RetraitDaoImpl;
import fr.eni.enchereENI.dao.impl.UserDaoImpl;

public class DaoFactory {
	
	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
	public static ArticleDao getArticleDao() {
		return new ArticleDaoImpl();
	}
	
	public static CategorieDao getCategorieDao() {
		return new CategorieDaoImpl();
	}
	
	public static EnchereDao getEnchereDao() {
		return new EnchereDaoImpl();
	}
	
	public static RetraitDao getRetraitDao() {
		return new RetraitDaoImpl();
	}
	}
