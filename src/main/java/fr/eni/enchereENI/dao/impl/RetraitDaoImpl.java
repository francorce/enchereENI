package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.enchereENI.bo.Retrait;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.RetraitDao;

public class RetraitDaoImpl implements RetraitDao {
	private static String SAVE = "INSERT into retraits (no_article, rue, code_postal, ville) VALUES(?, ?, ?, ?)";

	@Override
	public Retrait get(int id) throws SQLException {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Retrait retrait) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement saveRetrait = con.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
		
		saveRetrait.setInt(1, retrait.getArticle().getNoArticle());
		saveRetrait.setString(2, retrait.getRue());
		saveRetrait.setString(3, retrait.getCp());	
		saveRetrait.setString(4, retrait.getVille());
		saveRetrait.executeUpdate();	
		int id = saveRetrait.executeUpdate();
		return id;
	}

	@Override
	public void update(Retrait t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Retrait t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
