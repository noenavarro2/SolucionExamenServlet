package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;

public class VideoGamesRepository implements Repository<VideoGame> {

	@Override
	public void insert(VideoGame videogame) {
		Connection conn = connection.openConnection(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Videogame (name,recomendedAge,launchDate,console)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.setString(2, videogame.getRecommendedAge());
			preparedStatement.setString(3, videogame.getLaunchDate());
			preparedStatement.setString(4, videogame.getConsole());
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
	public void delete(VideoGame videogame) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			preparedStatement = conn.prepareStatement("DELETE FROM Videogame WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.closePreparedStatement(preparedStatement);
			connection.closeConnection(conn);
		}
	}

	@Override
	public List<VideoGame> listAll() {
		List<VideoGame> videogames = new ArrayList<VideoGame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Videogame");
			while (resultSet.next()) {
				VideoGame videogame = new VideoGame();
				videogame.setTitle(resultSet.getString("title"));
				videogame.setRecommendedAge(resultSet.getString("recommendedAge"));
				videogame.setLaunchDate(resultSet.getString("launchDate"));
				videogame.setConsole(resultSet.getString("console"));
				videogames.add(videogame);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return videogames;
	}

	public List<VideoGame> searchByConsole(Console console) {
		List<VideoGame> listVideogames = new ArrayList<VideoGame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT + WHERE name = ?");
			prepareStatement.setString(1, console.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame VideogameInDatabase = new VideoGame();
				VideogameInDatabase.setTitle(resultSet.getString(1));
				VideogameInDatabase.setRecommendedAge(resultSet.getString(2));
				VideogameInDatabase.setLaunchDate(resultSet.getString(3));
				VideogameInDatabase.setConsole(resultSet.getString(4));
				listVideogames.add(VideogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return listVideogames;
	}

	public List<VideoGame> searchByRecommendedAge(String recommendedAge) {
		List<VideoGame> listVideogames = new ArrayList<VideoGame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			prepareStatement = conn.prepareStatement(recommendedAge);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame videogameInDatabase = new VideoGame();
				videogameInDatabase.setTitle(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setLaunchDate(resultSet.getString(3));
				videogameInDatabase.setConsole(resultSet.getString(4));
				listVideogames.add(videogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return listVideogames;
	}
}
