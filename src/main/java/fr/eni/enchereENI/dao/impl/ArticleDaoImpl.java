package fr.eni.enchereENI.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
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
	private static String SAVE = "INSERT into articles_vendus (nom_article, description, photo, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String GET_BY_USER_ID = "SELECT * from articles_vendus WHERE no_utilisateur =  ?";
	private static String UPDATE = "UPDATE articles_vendus SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?";
	private static String SELECT_ARTICLE_ENCHERE_FINI = "SELECT * FROM articles_vendus WHERE date_fin_encheres < ?";
	private static String UPDATE_ARTICLE_STATE = "UPDATE articles_vendus SET isSold = ? WHERE no_article = ?";
	private static String DELETE = "DELETE from articles_vendus where no_article = ?";

	
	public void updateStateArticle(Article article) throws SQLException {
		Connection con;
		con = ConnectionProvider.getConnection();
		PreparedStatement updateArticleState = con.prepareStatement(UPDATE_ARTICLE_STATE);
		updateArticleState.setBoolean(1, article.isSold());
		updateArticleState.setInt(2, article.getNoArticle());
		updateArticleState.executeUpdate();
		con.close();
		updateArticleState.close();
	}
	
	
	public List<Article> selectArticleEnchereFini() throws SQLException {
		List<Article> articlesEnchereFini = new ArrayList<Article>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getArticleFini = con.prepareStatement(SELECT_ARTICLE_ENCHERE_FINI);
		LocalDateTime now = LocalDateTime.now();
		getArticleFini.setTimestamp(1, java.sql.Timestamp.valueOf(now));
		rs = getArticleFini.executeQuery();
		while (rs.next()) {
			Article article = new Article();
			article.setNoArticle(rs.getInt("no_article"));
			article.setNomArticle(rs.getString("nom_article"));
			article.setDescription(rs.getString("description"));
			article.setDebutEnchere(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
			article.setFinEnchere(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
			article.setPrixInitial(rs.getInt("prix_initial"));
			article.setPrixVente(rs.getInt("prix_vente"));
			article.setSold(rs.getBoolean("isSold"));
			User vendeur = new User();
			vendeur = DaoFactory.getUserDao().get(rs.getInt("no_utilisateur"));
			article.setVendeur(vendeur);

			Categorie cat = new Categorie();
			cat = DaoFactory.getCategorieDao().getById(rs.getInt("no_categorie"));
			article.setCategorie(cat);
			articlesEnchereFini.add(article);
		}

		return articlesEnchereFini;
	}

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
			Blob blob =  rs.getBlob("photo");
			article.setPhoto(blob.getBytes(0, (int) blob.length()));
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
		Blob blob = con.createBlob();
		blob.setBytes(id, a.getPhoto());
		saveArticle.setBlob(3,blob);
		saveArticle.setTimestamp(4, java.sql.Timestamp.valueOf(a.getDebutEnchere()));
		saveArticle.setTimestamp(5, java.sql.Timestamp.valueOf(a.getFinEnchere()));
		saveArticle.setInt(6, a.getPrixInitial());
		saveArticle.setInt(7, a.getPrixVente());
		saveArticle.setInt(8, a.getVendeur().getNo_utilisateur());
		saveArticle.setInt(9, a.getCategorie().getNoCategorie());
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
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement updateArticle = con.prepareStatement(UPDATE);
		updateArticle.setString(1, a.getNomArticle());
		updateArticle.setString(2, a.getDescription());
		updateArticle.setTimestamp(3, java.sql.Timestamp.valueOf(a.getDebutEnchere()));
		updateArticle.setTimestamp(4, java.sql.Timestamp.valueOf(a.getFinEnchere()));
		updateArticle.setInt(5, a.getPrixInitial());
		updateArticle.setInt(6, a.getPrixVente());
		updateArticle.setInt(7, a.getVendeur().getNo_utilisateur());
		updateArticle.setInt(8, a.getCategorie().getNoCategorie());
		updateArticle.setInt(9, a.getNoArticle());
		updateArticle.executeUpdate();
	}

	@Override
	public void delete(Article a) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement deleteUser = con.prepareStatement(DELETE);
		deleteUser.setInt(1, a.getNoArticle());
		Boolean requesteIsOk = deleteUser.execute();
		con.close();
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
