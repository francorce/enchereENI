package fr.eni.enchereENI.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchereENI.bo.Enchere;

public interface EnchereDao extends Dao<Enchere> {
	
	public List<Enchere> getByUserId(int id) throws SQLException;
	public List<Enchere> getByArticleId(int articleId) throws SQLException;
	public List<Enchere> getByArticleAndUserId(int articleId, int userId) throws SQLException; 
}
