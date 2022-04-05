package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.UserDao;

public class UserDaoImpl implements UserDao {
	
	private static String GET_USER = "SELECT * from utilisateurs where no_utilisateur = ?";
	private static String GET_ALL_USER = "SELECT * from utilisateurs";

	public Optional<User> get(int id) throws SQLException {
		User user = new User();
		Connection con = ConnectionProvider.getConnection();
        PreparedStatement getUser = con.prepareStatement(GET_USER);
        getUser.setInt(1, id);
		ResultSet rs = getUser.executeQuery();
	    while (rs.next()){
	    	user.setNo_utilisateur(rs.getInt("no_utilisateur"));
	    	user.setPseudo(rs.getString("pseudo"));
	    	user.setNom(rs.getString("nom"));
	    	user.setPrenom(rs.getString("prenom"));
	    	user.setEmail(rs.getString("email"));
	    	user.setTelephone(rs.getString("telephone"));
	    	user.setRue(rs.getString("rue"));
	    	user.setCp(rs.getString("code_postal"));
	    	user.setVille(rs.getString("ville"));
	    	user.setPassword(rs.getString("mot_de_passe"));
	    	user.setCredit(rs.getInt("credit"));
	    	user.setAdmin(rs.getBoolean("administrateur"));
         }
		con.close();
		rs.close();
		return Optional.of(user);
	}
	
	
	public List<User> getAll() throws SQLException {
		List userList = new ArrayList<User>();
		
		Connection con;
		ResultSet rs;
			con = ConnectionProvider.getConnection();
			  PreparedStatement getUser = con.prepareStatement(GET_ALL_USER);
				 rs = getUser.executeQuery();
			    while (rs.next()){
			    	User user = new User();
			    	user.setNo_utilisateur(rs.getInt("no_utilisateur"));
			    	user.setPseudo(rs.getString("pseudo"));
			    	user.setNom(rs.getString("nom"));
			    	user.setPrenom(rs.getString("prenom"));
			    	user.setEmail(rs.getString("email"));
			    	user.setTelephone(rs.getString("telephone"));
			    	user.setRue(rs.getString("rue"));
			    	user.setCp(rs.getString("code_postal"));
			    	user.setVille(rs.getString("ville"));
			    	user.setPassword(rs.getString("mot_de_passe"));
			    	user.setCredit(rs.getInt("credit"));
			    	user.setAdmin(rs.getBoolean("administrateur"));
			    	userList.add(user);
			   
		         }
			 	con.close();
				rs.close();
		return userList;
	}


	@Override
	public Optional<User> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}
	
}
