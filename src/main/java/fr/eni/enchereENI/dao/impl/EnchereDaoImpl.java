package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
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
	private static String SAVE = "INSERT into encheres (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?, ?, ?, ?)";
	private static String GET_ENCHERE_FINI = "SELECT enchere.no_utilisateur, enchere.no_article from encheres, article_vendus WHERE encheres.no_article = article_vendus.no_article AND articles_vendus.date_fin_encheres > ?";

	private static class Gagnant{
		int noUtilisateur;
		int noArticle;
		
		public Gagnant(int noUtilisateur, int noArticle) {
			super();
			this.noUtilisateur = noUtilisateur;
			this.noArticle = noArticle;
		}
		
	}
	
	
	
	public List<Gagnant> getEnchereFini() throws SQLException {
		List<Gagnant> gagnants = new ArrayList<EnchereDaoImpl.Gagnant>();
		
		LocalDateTime now = LocalDateTime.now();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement enchereFini = con.prepareStatement(GET_ENCHERE_FINI);
		enchereFini.setTimestamp(1, java.sql.Timestamp.valueOf(now));
		rs = enchereFini.executeQuery();
		while(rs.next()) {
			Gagnant gagnant = new Gagnant(rs.getInt(1), rs.getInt(2));
			gagnants.add(gagnant);
		}
		return gagnants;
	}
	
	
	

	public List<Enchere> getByUserId(int id) throws SQLException {
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

			enchere.setDateEnchere(rs.getTimestamp("date_enchere").toLocalDateTime());
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
			enchere.setDateEnchere(rs.getTimestamp("date_enchere").toLocalDateTime());
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
	public int save(Enchere enchere) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement saveEnchere = con.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
		int id = 0;
		saveEnchere.setTimestamp(1, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
		saveEnchere.setFloat(2, enchere.getMontantEnchere());
		saveEnchere.setInt(3, enchere.getArticles().getNoArticle());
		saveEnchere.setInt(4, enchere.getEncherisseur().getNo_utilisateur());

		int affectedRows = saveEnchere.executeUpdate();
		ResultSet keys = saveEnchere.getGeneratedKeys();
		if (keys.next()) {
			id = keys.getInt(1);
		}
		enchere.setNoEnchere(id);
		return id;
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
			enchere.setDateEnchere(rs.getTimestamp("date_enchere").toLocalDateTime());
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
