package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.ArticleDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class ArticleDaoImpl implements ArticleDao {
	private static String GET_BY_ID = "SELECT * from articles_vendus where no_article = ?";
	private static String GET_ALL = "SELECT * from articles_vendus";
	private static String SAVE = "INSERT into articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static String GET_BY_USER_ID = "SELECT * from articles_vendus WHERE no_utilisateur =  ?";

	public List<Article> getAll() throws SQLException {
		List<Article> articleList = new ArrayList<Article>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getAllUser = con.prepareStatement(GET_ALL);
		rs = getAllUser.executeQuery();
		while (rs.next()) {
			Article article = new Article();
			article.setNoArticle(rs.getInt("no_article"));
			article.setNomArticle(rs.getString("nom_article"));
			article.setDescription(rs.getString("description"));
			article.setDebutEnchere(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
			article.setFinEnchere(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
			article.setPrixInitial(rs.getInt("prix_initial"));
			article.setPrixVente(rs.getInt("prix_vente"));

			User vendeur = new User();
			vendeur = DaoFactory.getUserDao().get(rs.getInt("no_utilisateur"));
			article.setVendeur(vendeur);

			Categorie cat = new Categorie();
			cat = DaoFactory.getCategorieDao().getById(rs.getInt("no_categorie"));
			article.setCategorie(cat);

			articleList.add(article);
		}
		con.close();
		rs.close();
		return articleList;
	}

	@Override
	public Article get(int id) throws SQLException {
		Article article = null;
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement getArticleById = con.prepareStatement(GET_BY_ID);
		getArticleById.setInt(1, id);
		ResultSet rs = getArticleById.executeQuery();
		if (rs.next()) {
			article = new Article();
			article.setNoArticle(rs.getInt("no_article"));
			article.setNomArticle(rs.getString("nom_article"));
			article.setDescription(rs.getString("description"));
			article.setDebutEnchere(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
			article.setFinEnchere(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
			article.setPrixInitial(rs.getInt("prix_initial"));
			article.setPrixVente(rs.getInt("prix_vente"));

			User vendeur = new User();
			vendeur = DaoFactory.getUserDao().get(rs.getInt("no_utilisateur"));
			article.setVendeur(vendeur);

			Categorie cat = new Categorie();
			cat = DaoFactory.getCategorieDao().getById(rs.getInt("no_categorie"));
			article.setCategorie(cat);
		}
		con.close();
		rs.close();
		return article;
	}

	@Override
	public int save(Article a) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement saveArticle = con.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
		int id = 0;
		saveArticle.setString(1, a.getNomArticle());
		saveArticle.setString(2, a.getDescription());
		saveArticle.setTimestamp(3, java.sql.Timestamp.valueOf(a.getDebutEnchere()));
		saveArticle.setTimestamp(4, java.sql.Timestamp.valueOf(a.getFinEnchere()));
		saveArticle.setInt(5, a.getPrixInitial());
		saveArticle.setInt(6, a.getPrixVente());
		saveArticle.setInt(7, a.getVendeur().getNo_utilisateur());
		saveArticle.setInt(8, a.getCategorie().getNoCategorie());
		int affectedRows = saveArticle.executeUpdate();
		ResultSet keys = saveArticle.getGeneratedKeys();
		if (keys.next()) {
			id = keys.getInt(1);
		}
		a.setNoArticle(id);
		return id;
	}

	@Override
	public void update(Article a) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Article a) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> getByVendorId(int vendorId) throws SQLException {
		List<Article> articleList = new ArrayList<Article>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getArticleByUserId = con.prepareStatement(GET_BY_USER_ID);
		getArticleByUserId.setInt(1, vendorId);
		rs = getArticleByUserId.executeQuery();

		while (rs.next()) {
			Article article = new Article();
			article.setNoArticle(rs.getInt("no_article"));
			article.setNomArticle(rs.getString("nom_article"));
			article.setDescription(rs.getString("description"));
			article.setDebutEnchere(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
			article.setFinEnchere(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
			article.setPrixInitial(rs.getInt("prix_initial"));
			article.setPrixVente(rs.getInt("prix_vente"));

			User vendeur = new User();
			vendeur = DaoFactory.getUserDao().get(rs.getInt("no_utilisateur"));
			article.setVendeur(vendeur);

			Categorie cat = new Categorie();
			cat = DaoFactory.getCategorieDao().getById(rs.getInt("no_categorie"));
			article.setCategorie(cat);

			articleList.add(article);
		}
		con.close();
		rs.close();
		return articleList;
	}

}
