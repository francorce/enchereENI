package fr.eni.enchereENI.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchereENI.bo.Enchere;

public interface EnchereDao extends Dao<Enchere> {
	
	@Override
	public Enchere get(int id) throws SQLException;
	
	@Override
	public List<Enchere> getAll() throws SQLException;
	
	@Override
	public void save(Enchere enchere) throws SQLException;

	@Override
	public void update(Enchere enchere) throws SQLException;

	@Override
	public void delete(Enchere enchere) throws SQLException;
	
	public List<Enchere> getByUserId(String email, String password)throws SQLException;
	

}
