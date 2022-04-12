package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Enchere;
import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.DaoFactory;
import fr.eni.enchereENI.dao.RetraitDao;

public class RetraitDaoImpl implements RetraitDao {
	private static String SAVE = "INSERT into retraits ( no_article,rue, code_postal, ville) VALUES(?, ?, ?, ?)";
	private static String GET_BY_ARTICLEID = "SELECT * from retraits WHERE no_article = ?";
	private static String GET_ALL = "SELECT * from retraits";
	
	
	
	@Override
	public Retrait get(int id) throws SQLException {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> getAll() throws SQLException {
		List<Retrait> retraitList = new ArrayList<Retrait>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getAllRetrait = con.prepareStatement(GET_ALL);
		rs = getAllRetrait.executeQuery();
		while (rs.next()) {
			Retrait retrait= new Retrait();
			retrait.setRue(rs.getString("rue"));
			retrait.setCp(rs.getString("code_postal"));
			retrait.setVille(rs.getString("ville"));
			

			Article article = new Article();
			article = DaoFactory.getArticleDao().get(rs.getInt("no_article"));
			retrait.setArticle(article);
			retraitList.add(retrait);
		}
		con.close();
		rs.close();
		return retraitList;
	}

	@Override
	public int save(Retrait retrait) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement saveRetrait = con.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
		saveRetrait.setInt(1, retrait.getArticle().getNoArticle());
		saveRetrait.setString(2, retrait.getRue());
		saveRetrait.setString(3, retrait.getCp());	
		saveRetrait.setString(4, retrait.getVille());
		int affectedRows = saveRetrait.executeUpdate();
		con.close();
		saveRetrait.close();
		return affectedRows;
	}

	@Override
	public void update(Retrait t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	

	@Override
	public void delete(Retrait t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Retrait geyByArticleId(int articleId) throws SQLException {
		Retrait retrait = null;
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement getByArticle = con.prepareStatement(GET_BY_ARTICLEID);
		ResultSet rs;
		getByArticle.setInt(1, articleId);
		rs = getByArticle.executeQuery();
		if(rs.next()) {
			retrait=new Retrait();
			Article article = new Article();
			article = DaoFactory.getArticleDao().get(rs.getInt("no_article"));
			retrait.setArticle(article);
			retrait.setRue(rs.getString("rue"));
			retrait.setCp(rs.getString("code_postal"));
			retrait.setVille(rs.getString("ville"));

		}
		con.close();
		getByArticle.close();
		return retrait;
	}

}
