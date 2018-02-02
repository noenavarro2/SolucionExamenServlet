package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.Console;
import es.salesianos.model.Company;

public class ConsolesRepository {
	
	private static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/createConsoles.sql'";
	ConnectionH2 manager = new ConnectionH2();
	CompanysRepository repository = new CompanysRepository();
	
	public Console search(Console consoleForm) {
		Console consoleInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection connection = manager.open(JDBCURL);
		try {
			prepareStatement = connection.prepareStatement("SELECT * FROM consoles WHERE nombre = ?");
			prepareStatement.setString(1, consoleForm.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(0));
				consoleInDatabase.setCompany(repository.myCompany(resultSet.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connection);
		}		
		return consoleInDatabase;
	}
	
	public void insert(Console consoleForm) {
		Connection conn = manager.open(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO consoles (name,company) VALUES (?, ?)");
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.setString(2, consoleForm.getCompany().getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}		
	}
	
	public void update(Console consoleForm) {
		Connection connection = manager.open(JDBCURL);
		manager.close(connection);
	}
	
	public List<Console> searchAll() {
		List<Console> listConsoles= new ArrayList<Console>();
		Connection connection = manager.open(JDBCURL);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement("SELECT * FROM consoles");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Console consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(1));
				consoleInDatabase.setCompany(repository.myCompany(resultSet.getString(2)));
				listConsoles.add(consoleInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connection);
		}		
		return listConsoles;
	}
	
	public void delete(Console console) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = manager.open(JDBCURL);
			preparedStatement = connection.prepareStatement("DELETE * FROM consoles WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connection);
		}		
	}
	
	public List<Company> companysList(){
		return repository.listAllCompanys();
	}
}
