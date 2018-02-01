package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;
import es.salesianos.model.Company;

public class ConsolesRepository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/createConsolas.sql'";
	ConnectionH2 manager = new ConnectionH2();
	CompaniesRepository rep = new CompaniesRepository();
	
	public Console search(Console consolaFormulario) {
		Console consolaInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM CONSOLAS WHERE nombre = ?");
			prepareStatement.setString(1, consolaFormulario.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				consolaInDatabase = new Console();
				consolaInDatabase.setName(resultSet.getString(0));
				consolaInDatabase.setCompany(rep.myEmpresa(resultSet.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			
		}
		manager.close(conn);
		return consolaInDatabase;
	}
	
	public void insert(Console consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO consoles (name,company) VALUES (?, ?)");
			preparedStatement.setString(1, consolaFormulario.getName());
			preparedStatement.setString(2, consolaFormulario.getCompany().getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}
	
	public void update(Console consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}
	
	public List<Console> searchAll() {
		List<Console> listConsolas= new ArrayList<Console>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM consoles");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Console consolaInDatabase = new Console();
				consolaInDatabase.setName(resultSet.getString(1));
				consolaInDatabase.setCompany(rep.myEmpresa(resultSet.getString(2)));
				
				listConsolas.add(consolaInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listConsolas;
	}
	
	public void delete(Console console) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("DELETE * FROM Conoles WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}
	
	public List<Company> empresasList(){
		return rep.listAllCompanies();
	}
}
