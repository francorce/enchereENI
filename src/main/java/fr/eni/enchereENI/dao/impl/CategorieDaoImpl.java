package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.CategorieDao;

public class CategorieDaoImpl implements CategorieDao {
	
	private static String GET_BY_ID = "SELECT * from categories where no_categorie = ?";
	private static String GET_BY_LIBELLE = "SELECT * from categories where libelle = ?";

	@Override
	public Categorie get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Categorie t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Categorie t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Categorie t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie getById(int id) throws SQLException {
		Categorie categorie = null;
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement getById = con.prepareStatement(GET_BY_ID);
		getById.setInt(1, id);
		ResultSet rs = getById.executeQuery();
		if (rs.next()) {
			categorie = new Categorie();
			categorie.setNoCategorie(rs.getInt("no_categorie"));
			categorie.setLibelle(rs.getString("libelle"));
		}
		con.close();
		rs.close();
		return categorie;
	}

	@Override
	public Categorie getByLibelle(String libelle) throws SQLException {
		Categorie categorie = null;
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement getById = con.prepareStatement(GET_BY_ID);
		getById.setString(1, libelle);
		ResultSet rs = getById.executeQuery();
		if (rs.next()) {
			categorie = new Categorie();
			categorie.setNoCategorie(rs.getInt("no_categorie"));
			categorie.setLibelle(rs.getString("libelle"));
		}
		con.close();
		rs.close();
		return categorie;
	}
	
	

}
