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

	private static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/createVideoGames.sql'";
	ConnectionH2 manager = new ConnectionH2();

	public List<VideoGame> searchAll() {
		List<VideoGame> listVideoGames = new ArrayList<VideoGame>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = manager.open(JDBCURL);
			prepareStatement = connection.prepareStatement("SELECT * FROM videoGames");
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
			manager.close(connection);
		}
		return listVideoGames;
	}

	public VideoGame search(VideoGame videoGameForm) {
		VideoGame videoGameInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection connection = null;
		try {
			connection = manager.open(JDBCURL);
			prepareStatement = connection.prepareStatement("SELECT * FROM videoGames WHERE title = ?");
			prepareStatement.setString(1, videoGameForm.getTitle());
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
			manager.close(connection);
		}
		return videoGameInDatabase;
	}

	public void insert(VideoGame videoGameForm) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = manager.open(JDBCURL);
			preparedStatement = connection.prepareStatement(
					"INSERT INTO videoGames (title,recommendedAge,launchDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, videoGameForm.getTitle());
			preparedStatement.setString(2, videoGameForm.getRecommendedAge());
			preparedStatement.setDate(3, new java.sql.Date(videoGameForm.getLaunchDate().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connection);
		}
	}

	public void delete(VideoGame videoGameForm) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(JDBCURL);
			preparedStatement = conn.prepareStatement("DELETE * FROM videoGames WHERE title = ?");
			preparedStatement.setString(1, videoGameForm.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void update(VideoGame videoGameForm) {
		Connection connection = manager.open(JDBCURL);
		manager.close(connection);
	}
}
