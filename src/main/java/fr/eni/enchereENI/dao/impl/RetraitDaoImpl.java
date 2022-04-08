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
	private static String SAVE = "INSERT into retraits ( rue, code_postal, ville) VALUES(?, ?, ?)";

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
		saveRetrait.setString(1, retrait.getRue());
		saveRetrait.setString(2, retrait.getCp());	
		saveRetrait.setString(3, retrait.getVille());
		saveRetrait.executeUpdate();	
		int affectedRows = saveRetrait.executeUpdate();
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

}
