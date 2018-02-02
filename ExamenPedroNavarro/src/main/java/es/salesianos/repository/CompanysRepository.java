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

public class CompanysRepository {
	
	private static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Company search(Company companyForm) {
		Company companyInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection connection = manager.open(JDBCURL);
		try {
			prepareStatement = connection.prepareStatement("SELECT * FROM companys WHERE name = ?");
			prepareStatement.setString(1, companyForm.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				companyInDatabase = new Company();
				companyInDatabase.setName(resultSet.getString(0));
				companyInDatabase.setDate(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connection);
		}
		return companyInDatabase;
	}
	
	public List<Company> listAllCompanys() {
		List<Company> listCompanys= null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			listCompanys= new ArrayList<Company>();
			connection = manager.open(JDBCURL);
			prepareStatement = connection.prepareStatement("SELECT * FROM companys");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Company companyInDatabase = new Company();
				companyInDatabase.setName(resultSet.getString(1));
				companyInDatabase.setDate(resultSet.getString(2));
				listCompanys.add(companyInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connection);
		}
		return listCompanys;
	}
	
	public Company myCompany(String companyName) {
		Company company = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection connection = null;
		try {
			connection = manager.open(JDBCURL);
			prepareStatement = connection.prepareStatement("SELECT * FROM companys WHERE name = ?");
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
			manager.close(connection);
		}
		return company;
	}

}
