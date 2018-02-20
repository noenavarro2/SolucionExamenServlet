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

public class ConsoleRepository implements Repository<Console> {

	CompanyRepository repository = new CompanyRepository();

	@Override
	public void insert(Console console) {
		Connection conn = connection.openConnection(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Console (name,company)" + "VALUES (?, ?)");
			preparedStatement.setString(1, console.getName());
			preparedStatement.setInt(2, console.getCompany());
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
		List<Console> consolesList = new ArrayList<Console>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM console");
			while (resultSet.next()) {
				Console console = new Console();
				console.setName(resultSet.getString(1));
				console.setCompany(resultSet.getInt(2));
				consolesList.add(console);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return consolesList;
	}

	public List<Console> listAllByCompany(int company) {
		List<Console> consolesList = new ArrayList<Console>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM CONSOLE WHERE company = ?");
			while (resultSet.next()) {
				Console actualConsole = new Console();
				actualConsole.setName(resultSet.getString(1));
				actualConsole.setCompany(resultSet.getInt(2));
				consolesList.add(actualConsole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeConnection(conn);
		}
		return consolesList;
	}

}
