package fr.eni.enchereENI.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.dao.ArticleDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class ArticleManager {
	
	public List<Article> getAll(){
		List <Article> listeArticles = new ArrayList();
		ArticleDao articleDao = DaoFactory.getArticleDao();
		try {
			listeArticles = articleDao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeArticles;
	}

}
