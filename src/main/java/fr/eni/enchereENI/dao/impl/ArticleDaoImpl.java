package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.ArticleDao;
import fr.eni.enchereENI.dao.DaoFactory;

public class ArticleDaoImpl implements ArticleDao {
	private static String GET_BY_ID = "SELECT * from utilisateurs where no_utilisateur = ?";
	private static String GET_ALL = "SELECT * from articles_vendus";
	private static String DELETE = "DELETE from utilisateurs where no_utilisateur = ?";
	private static String UPDATE = "UPDATE utilisateurs SET pseudo =  ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?";
	private static String SAVE = "INSERT into utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
			article.setDebutEnchere(rs.getDate("date_debut_encheres"));
			article.setFinEnchere(rs.getDate("date_fin_encheres"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Article a) throws SQLException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}
}
