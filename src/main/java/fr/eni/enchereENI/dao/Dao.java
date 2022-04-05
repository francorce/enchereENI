package fr.eni.enchereENI.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	    
	    T get(int id) throws SQLException;
	    
	    List<T> getAll() throws SQLException ;
	    
	    void save(T t) throws SQLException;
	    
	    void update(T t) throws SQLException;
	    
	    void delete(T t) throws SQLException;
	
}
