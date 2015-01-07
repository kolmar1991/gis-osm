package pl.edu.agh.gis.osm.importer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

import org.postgresql.Driver;

import pl.edu.agh.gis.osm.importer.core.CommandLineOption;

public class GisOsmDao {

	private static final Class<Driver> POSTGRESQL_DRIVER = Driver.class;	
	private static final String URL_PATTERN = "jdbc:postgresql://%s/%s";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	
	private static final String CLEAR_TABLES_QUERY = "SELECT truncate_tables()";
	
	public void clearTables(Map<CommandLineOption, String> parameters) {
		//TODO logowanie paramterow
		System.out.println(parameters);
		
		try {
			Class.forName(POSTGRESQL_DRIVER.getName());
		} catch (ClassNotFoundException e) {
			//TODO logowanie i handlowanie bledow
			System.err.println("PostgreSql JDBC driver not found");
			e.printStackTrace();
			System.exit(-1);
		}
		
		String url = String.format(URL_PATTERN, parameters.get(CommandLineOption.DB_URL),parameters.get(CommandLineOption.DB_NAME));
		Properties properties = new Properties();
		properties.put(USER, parameters.get(CommandLineOption.DB_USER));
		properties.put(PASSWORD, parameters.get(CommandLineOption.DB_PASSWORD));
		
		try {
			Connection connection = DriverManager.getConnection(url, properties);
			Statement statement = connection.createStatement();
			
			//TODO moze zapytac uzytkownika czy aby na pewno chce to wyjebac?
			
			statement.execute(CLEAR_TABLES_QUERY);
			connection.close();
		} catch (SQLException e) {
			//TODO logowanie i handlowanie bledow
			System.err.println("Unable to get connection");
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	
}
