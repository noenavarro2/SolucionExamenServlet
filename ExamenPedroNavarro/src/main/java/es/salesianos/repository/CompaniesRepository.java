package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Company;

public class CompaniesRepository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Company search(Company empresaFormulario) {
		Company empresaInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM companies WHERE name = ?");
			prepareStatement.setString(1, empresaFormulario.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				empresaInDatabase = new Company();
				empresaInDatabase.setName(resultSet.getString(0));
				empresaInDatabase.setDate(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			
		}
		manager.close(conn);
		return empresaInDatabase;
	}
	
	public List<Company> listAllCompanies() {
		List<Company> listEmpresas= null;
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			listEmpresas= new ArrayList<Company>();
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement("SELECT * FROM companies");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Company empresaInDatabase = new Company();
				empresaInDatabase.setName(resultSet.getString(1));
				empresaInDatabase.setDate(resultSet.getString(2));
				listEmpresas.add(empresaInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listEmpresas;
	}
	
	public Company myEmpresa(String companyName) {
		Company company = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement("SELECT * FROM companies WHERE name = ?");
			prepareStatement.setString(1, companyName);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				company = new Company();
				company.setName(resultSet.getString(1));
				company.setDate(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return company;
	}

}
