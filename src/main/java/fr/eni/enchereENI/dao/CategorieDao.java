package fr.eni.enchereENI.dao;

import java.sql.SQLException;

import fr.eni.enchereENI.bo.Categorie;

public interface CategorieDao extends Dao<Categorie>{
	public Categorie getById(int id) throws SQLException;
	
	public Categorie getByLibelle(String libelle) throws SQLException;

}
