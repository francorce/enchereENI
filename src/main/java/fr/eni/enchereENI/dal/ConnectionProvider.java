package fr.eni.enchereENI.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {
	
	private static DataSource dataSource;
	
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			System.out.println("Connexion réussie");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
		
	}
	
	public static Connection getConnection() throws SQLException
	{
		
		
		return dataSource.getConnection();
	}

}
