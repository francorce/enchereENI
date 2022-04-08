package fr.eni.enchereENI.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchereENI.bo.Article;

public interface ArticleDao extends Dao<Article>{
	@Override
	public Article get(int id) throws SQLException;

	@Override
	public List<Article> getAll() throws SQLException;

	@Override
	public int save(Article a) throws SQLException;

	@Override
	public void update(Article a) throws SQLException;

	@Override
	public void delete(Article a) throws SQLException;
	
	public List<Article> getByVendorId(int vendorId) throws SQLException;
}
