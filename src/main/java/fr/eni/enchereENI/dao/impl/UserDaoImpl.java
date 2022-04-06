package fr.eni.enchereENI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.eni.enchereENI.bo.User;
import fr.eni.enchereENI.dal.ConnectionProvider;
import fr.eni.enchereENI.dao.UserDao;

public class UserDaoImpl implements UserDao {

	private static String GET_BY_ID = "SELECT * from utilisateurs where no_utilisateur = ?";
	private static String GET_ALL = "SELECT * from utilisateurs";
	private static String DELETE = "DELETE from utilisateurs where no_utilisateur = ?";
	private static String UPDATE = "UPDATE utilisateurs SET pseudo =  ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?";
	private static String SAVE = "INSERT into utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String GET_BY_PSEUDO_AND_PASSWORD = "SELECT * from utilisateurs where pseudo = ? and mot_de_passe = ?";
	private static String GET_BY_EMAIL_AND_PASSWORD = "SELECT * from utilisateurs where email = ? and mot_de_passe = ?";

	public User getByEmail(String email, String password) throws SQLException {
		User user = null;
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement getUser = con.prepareStatement(GET_BY_EMAIL_AND_PASSWORD);
		getUser.setString(1, email);
		getUser.setString(2, password);
		ResultSet rs = getUser.executeQuery();
		while (rs.next()) {
			user = new User();
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
		return user;
	}
	
	public User getByPseudo(String pseudo, String password) throws SQLException {
		User user = null;
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement getUser = con.prepareStatement(GET_BY_PSEUDO_AND_PASSWORD);
		getUser.setString(1, pseudo);
		getUser.setString(2, password);

		ResultSet rs = getUser.executeQuery();
		while (rs.next()) {
			user = new User();
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
		return user;
	}
	
	public List<User> getAll() throws SQLException {
		List userList = new ArrayList<User>();
		Connection con;
		ResultSet rs;
		con = ConnectionProvider.getConnection();
		PreparedStatement getAllUser = con.prepareStatement(GET_ALL);
		rs = getAllUser.executeQuery();
		while (rs.next()) {
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
	public User get(int id) throws SQLException {
		User user = null;
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement getUser = con.prepareStatement(GET_BY_ID);
		getUser.setInt(1, id);
		ResultSet rs = getUser.executeQuery();
		while (rs.next()) {
			user = new User();
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
		return user;
	}

	@Override
	public void save(User t) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement saveUser = con.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
		saveUser.setString(1, t.getPseudo());
		saveUser.setString(2, t.getNom());
		saveUser.setString(3, t.getPrenom());	
		saveUser.setString(4, t.getEmail());
		saveUser.setString(5, t.getTelephone());
		saveUser.setString(6, t.getRue());
		saveUser.setString(7, t.getCp());
		saveUser.setString(8, t.getVille());
		saveUser.setString(9, t.getPassword());
		saveUser.setInt(10, t.getCredit());
		saveUser.setBoolean(11, t.isAdmin());
		int id = saveUser.executeUpdate();
		t.setNo_utilisateur(id);
	}

	@Override
	public void update(User t) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement updateUser = con.prepareStatement(UPDATE);
		updateUser.setString(1, t.getPseudo());
		updateUser.setString(2, t.getNom());
		updateUser.setString(3, t.getPrenom());
		updateUser.setString(4, t.getEmail());
		updateUser.setString(5, t.getTelephone());
		updateUser.setString(6, t.getRue());
		updateUser.setString(7, t.getCp());
		updateUser.setString(8, t.getVille());
		updateUser.setString(9, t.getPassword());
		updateUser.setInt(10, t.getCredit());
		updateUser.setBoolean(11, t.isAdmin());
		updateUser.setInt(12, t.getNo_utilisateur());
		Boolean requesteIsOk = updateUser.execute();
	}

	@Override
	public void delete(User t) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement deleteUser = con.prepareStatement(DELETE);
		deleteUser.setInt(1, t.getNo_utilisateur());
		Boolean requesteIsOk = deleteUser.execute();
		con.close();
	}

}
