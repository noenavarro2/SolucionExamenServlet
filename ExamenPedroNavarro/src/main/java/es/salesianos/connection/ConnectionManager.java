package es.salesianos.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface ConnectionManager {

	public Connection openConnection(String jdbcUrl);
	public void closeConnection(Connection connection);
	public void closeStatement(Statement statement);
	public void closePreparedStatement(PreparedStatement prepStatement);
	public void closeResultSet(ResultSet resultSet);
}
