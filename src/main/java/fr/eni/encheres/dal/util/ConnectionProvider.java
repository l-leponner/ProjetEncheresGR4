package fr.eni.encheres.dal.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * Classe en charge de 
 * @author lleponner2022
 * @date 28 mars 2022
 */
abstract public class ConnectionProvider {
	private static DataSource dataSource;
	
	/**
	 * Au chargement de la classe, la DataSource est recherchée dans l'arbre JNDI
	 * S'il ne le trouve pas dataSource restera null et lors du getConnection, il essaiera de se connecter 
	 * en direct via le fichier settings.properties
	 */
	static
	{
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {

		}
	}
	
	/**
	 * Cette méthode retourne une connection opérationnelle 
	 * vers la base de données. 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		
		// le datasource existe
		if(ConnectionProvider.dataSource!=null) {
			return ConnectionProvider.dataSource.getConnection();
		}
		// sinon connection JDBC directe via la configuration du settings.properties
		else {
			try {
				Class.forName(Settings.getProperty("driverdb"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection cnx = null;
			try{
				cnx = DriverManager.getConnection(Settings.getProperty("urldb"), Settings.getProperty("userdb"), Settings.getProperty("passworddb"));
			}
			catch(SQLException e){
				throw new SQLException(e.getMessage());
			}
			return cnx;			
		}
	}
}
