package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.VideoGame;

public class VideoGameRepository implements Repository<VideoGame> {

	@Override
	public void insert(VideoGame videogame) {
		Connection conn = connection.openConnection(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Videogame (name,recomendedAge,launchDate,console)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.setString(2, videogame.getRecommendedAge());
			preparedStatement.setString(3, videogame.getLaunchDate());
			preparedStatement.setInt(4, videogame.getCompany());
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
			preparedStatement = conn.prepareStatement("DELETE FROM Videogame WHERE id = ?");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closePreparedStatement(preparedStatement);
			connection.closeConnection(conn);
		}
	}

	@Override
	public List<VideoGame> listAll() {
		List<VideoGame> listVideoGame = new ArrayList<VideoGame>();
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
				videogame.setCompany(resultSet.getInt("console"));
				listVideoGame.add(videogame);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return listVideoGame;
	}

	public List<VideoGame> searchByCompany(Company company) {
		List<VideoGame> listVideoGame = new ArrayList<VideoGame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT  * FROM VIDEOGAME WHERE company = ?");
			prepareStatement.setString(1, company + "");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame Videogame = new VideoGame();
				Videogame.setTitle(resultSet.getString(1));
				Videogame.setRecommendedAge(resultSet.getString(2));
				Videogame.setLaunchDate(resultSet.getString(3));
				Videogame.setCompany(resultSet.getInt(4));
				listVideoGame.add(Videogame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return listVideoGame;
	}

	public List<VideoGame> searchByRecommendedAge(String recommendedAge) {
		List<VideoGame> listVideoGame = new ArrayList<VideoGame>();
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
				VideoGame videogame = new VideoGame();
				videogame.setTitle(resultSet.getString(1));
				videogame.setRecommendedAge(resultSet.getString(2));
				videogame.setLaunchDate(resultSet.getString(3));
				videogame.setCompany(resultSet.getInt(4));
				listVideoGame.add(videogame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return listVideoGame;
	}
	public List<VideoGame> orderByLaunchDate() {
		List<VideoGame> listVideogame = new ArrayList<VideoGame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = connection.openConnection(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM VIDEOGAME ORDER BY launchDate ASC");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				VideoGame videoGame = new VideoGame();
				videoGame.setTitle(resultSet.getString(1));
				videoGame.setRecommendedAge(resultSet.getString(2));
				videoGame.setLaunchDate(resultSet.getString(3));
				videoGame.setCompany(resultSet.getInt(4));
				listVideogame.add(videoGame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.closeResultSet(resultSet);
			connection.closeStatement(statement);
			connection.closeConnection(conn);
		}
		return listVideogame;
	}
}
