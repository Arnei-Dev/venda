/**
 * 
 */
package br.com.arneidev.dao.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mdias
 *
 */
public class ConnectionFactory {
	
	private static Connection connection;
	
	private ConnectionFactory(Connection connection) {
		
	}
	public static Connection getConnection() throws SQLException{
		if(connection == null) {
			connection = initConnection();
			return connection;
		}else if(connection.isClosed()) {
			connection = initConnection();
			return connection;
		}else {
			return connection;
		}
	}
	private static Connection initConnection() {
		try {			
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendas_e", "postgres", "136582Ma");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
