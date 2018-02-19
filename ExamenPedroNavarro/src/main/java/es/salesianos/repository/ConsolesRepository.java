package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.Console;
import es.salesianos.model.Company;

public class ConsolesRepository implements Repository<Console> {
	
	CompanysRepository repository = new CompanysRepository();
	
	@Override
	public void insert(Console console) {
		Connection conn = connection.openConnection(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Console (name,company)" + "VALUES (?, ?)");
			preparedStatement.setString(1, console.getName());
			preparedStatement.setString(2, console.getCompany());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closePreparedStatement(preparedStatement);
			connection.closeConnection(conn);
		}
	}

	@Override
	public void delete(Console console) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			preparedStatement = conn.prepareStatement("DELETE FROM Console WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.closePreparedStatement(preparedStatement);
			connection.closeConnection(conn);
		}	
	}
	@Override
	public List<Console> listAll() {
		List<Console> consoles = new ArrayList<Console>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Console WHERE name = ?");
			while (resultSet.next()) {
				Console console = new Console();
				console.setName(resultSet.getString("name"));
				console.setCompany(resultSet.getString("company"));
				consoles.add(console);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return consoles;
	}

	
	public List<Console> listAllByCompany() {
		List<Console> consoles = new ArrayList<Console>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM console order by name");
			while (resultSet.next()) {
				Console actualConsole = new Console();
				actualConsole.setName(resultSet.getString("name"));
				actualConsole.setCompany(resultSet.getString("company"));
				consoles.add(actualConsole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeConnection(conn);
		}
		return consoles;
	}
		
}
