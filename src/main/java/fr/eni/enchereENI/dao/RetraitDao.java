package fr.eni.enchereENI.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchereENI.bo.Article;
import fr.eni.enchereENI.bo.Retrait;

public interface RetraitDao extends Dao<Retrait> {
	public Retrait geyByArticleId(int articleId) throws SQLException;
	public void updateRetrait(Retrait retrait)  throws SQLException;
}
