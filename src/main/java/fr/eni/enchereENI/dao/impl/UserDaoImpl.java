package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.UserDao;

public class UserDaoImpl extends UserDao {
	
	private static String GET_USER = "SELECT * from utilisateurs where no_utilisateur = ?";
	
	@SuppressWarnings("null")
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
	
}
