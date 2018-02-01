package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.VideoGame;

public class VideoGamesRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/createVideojuegos.sql'";
	ConnectionH2 manager = new ConnectionH2();

	public List<VideoGame> searchAll() {
		List<VideoGame> listVideoGames = new ArrayList<VideoGame>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement("SELECT * FROM videoGames");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				VideoGame videoGameInDatabase = new VideoGame();
				videoGameInDatabase.setTitle(resultSet.getString(1));
				videoGameInDatabase.setRecommendedAge(resultSet.getString(2));
				videoGameInDatabase.setLaunchDate(resultSet.getString(3));
				listVideoGames.add(videoGameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listVideoGames;
	}

	public VideoGame search(VideoGame videojuegoFormulario) {
		VideoGame videoGameInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement("SELECT * FROM videoGames WHERE title = ?");
			prepareStatement.setString(1, videojuegoFormulario.getTitle());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				videoGameInDatabase = new VideoGame();
				videoGameInDatabase.setTitle(resultSet.getString(0));
				videoGameInDatabase.setRecommendedAge(resultSet.getString(1));
				videoGameInDatabase.setLaunchDate(resultSet.getDate(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return videoGameInDatabase;
	}

	public void insert(VideoGame videojuegoFormulario) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(
					"INSERT INTO videoGames (title,recommendedAge,launchDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, videojuegoFormulario.getTitle());
			preparedStatement.setString(2, videojuegoFormulario.getRecommendedAge());
			preparedStatement.setDate(3, new java.sql.Date(videojuegoFormulario.getLaunchDate().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}

	public void delete(VideoGame videojuegoFormulario) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("DELETE * FROM videoGames WHERE title = ?");
			preparedStatement.setString(1, videojuegoFormulario.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}

	public void update(VideoGame formVideoGame) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}
}
