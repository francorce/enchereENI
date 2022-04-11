package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.EnchereDao;

public class EnchereDaoImpl implements EnchereDao {
	private static String GET_ALL = "SELECT * from encheres";
	private static String GET_BY_USER_ID = "SELECT * from encheres WHERE no_utilisateur = ?";
	private static String GET_BY_ARTICLE_ID = "SELECT * from encheres WHERE no_article = ?";

	
	public List<Enchere> getByUserId(int id) throws SQLException{
		List<Enchere> enchereList = new ArrayList<Enchere>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getAllEnchereByUserId = con.prepareStatement(GET_BY_USER_ID);
		getAllEnchereByUserId.setInt(1, id);
		rs = getAllEnchereByUserId.executeQuery();
		
		while (rs.next()) {
			Enchere enchere = new Enchere();
			enchere.setNoEnchere(rs.getInt("no_enchere"));
			enchere.setDateEnchere(rs.getDate("date_enchere"));
			enchere.setMontantEnchere(rs.getInt("montant_enchere"));
			
			User acheteur = new User();
			acheteur = DaoFactory.getUserDao().get(rs.getInt("no_utilisateur"));
			enchere.setEncherisseur(acheteur);
			
			Article article = new Article();
			article = DaoFactory.getArticleDao().get(rs.getInt("no_article"));
			enchere.setArticles(article);
			enchereList.add(enchere);
		}
		con.close();
		rs.close();
		return enchereList;
	}
	
	@Override
	public Enchere get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getAll() throws SQLException {
		List<Enchere> enchereList = new ArrayList<Enchere>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getAllEnchere = con.prepareStatement(GET_ALL);
		rs = getAllEnchere.executeQuery();
		while (rs.next()) {
			Enchere enchere = new Enchere();
			enchere.setNoEnchere(rs.getInt("no_enchere"));
			enchere.setDateEnchere(rs.getDate("date_enchere"));
			enchere.setMontantEnchere(rs.getInt("montant_enchere"));
			
			User acheteur = new User();
			acheteur = DaoFactory.getUserDao().get(rs.getInt("no_utilisateur"));
			enchere.setEncherisseur(acheteur);
			
			Article article = new Article();
			article = DaoFactory.getArticleDao().get(rs.getInt("no_article"));
			enchere.setArticles(article);
			enchereList.add(enchere);
		}
		con.close();
		rs.close();
		return enchereList;
	}

	@Override
	public int save(Enchere t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Enchere t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Enchere t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> getByArticleId(int articleId) throws SQLException {
		List<Enchere> enchereList = new ArrayList<Enchere>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getAllEnchereByUserId = con.prepareStatement(GET_BY_ARTICLE_ID);
		getAllEnchereByUserId.setInt(1, articleId);
		rs = getAllEnchereByUserId.executeQuery();
		
		while (rs.next()) {
			Enchere enchere = new Enchere();
			enchere.setNoEnchere(rs.getInt("no_enchere"));
			enchere.setDateEnchere(rs.getDate("date_enchere"));
			enchere.setMontantEnchere(rs.getInt("montant_enchere"));
			
			User acheteur = new User();
			acheteur = DaoFactory.getUserDao().get(rs.getInt("no_utilisateur"));
			enchere.setEncherisseur(acheteur);
			
			Article article = new Article();
			article = DaoFactory.getArticleDao().get(rs.getInt("no_article"));
			enchere.setArticles(article);
			enchereList.add(enchere);
		}
		con.close();
		rs.close();
		return enchereList;
	}
	
	

}
