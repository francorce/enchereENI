package fr.eni.enchereENI.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchereENI.bo.User;

public interface UserDao extends Dao<User>{

	@Override
	public User get(int id) throws SQLException;
	
	@Override
	public List<User> getAll() throws SQLException;
	

	@Override
	public int save(User t) throws SQLException;

	@Override
	public void update(User t) throws SQLException;

	@Override
	public void delete(User t) throws SQLException;
	
	public User getByEmail(String email, String password)throws SQLException;
	
	public User getByPseudo(String pseudo, String password)throws SQLException;

	public User getByUUID(String uuid) throws SQLException;
	
	public void setUUID(User user) throws SQLException;
}
