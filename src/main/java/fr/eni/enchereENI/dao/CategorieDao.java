package fr.eni.enchereENI.dao;

import java.sql.SQLException;

import fr.eni.enchereENI.bo.Categorie;
import fr.eni.enchereENI.bo.User;

public interface CategorieDao extends Dao<Categorie>{
	public Categorie getById(int id) throws SQLException;
	
	public Categorie getByLibelle(String libelle) throws SQLException;
	
	@Override
	public void delete(Categorie t) throws SQLException;
	
	@Override
	public void update(Categorie t) throws SQLException;
}
