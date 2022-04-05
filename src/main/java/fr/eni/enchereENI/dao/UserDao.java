package fr.eni.enchereENI.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.eni.enchereENI.bo.User;

public interface UserDao extends Dao<User>{

	@Override
	public Optional<User> get(long id) throws SQLException;
	
	@Override
	public List<User> getAll() throws SQLException;
	

	@Override
	public void save(User t) throws SQLException;

	@Override
	public void update(User t, String[] params) throws SQLException;

	@Override
	public void delete(User t) throws SQLException;
	
	
}
