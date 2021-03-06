package es.salesianos.repository;


import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import es.salesianos.model.Company;
import es.salesianos.model.VideoGame;

@Repository
public class VideoGameRepository implements RepositoryInterface<VideoGame> {
	
	private List beanPropertyRowMapper(String sql) {
		return jdbctemplate.query(sql, new BeanPropertyRowMapper(VideoGame.class));
	}
	
	private static Logger log = LogManager.getLogger(CompanyRepository.class);
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private NamedParameterJdbcTemplate nameParameterdJdbcTemplate;

	@Override
	public void insert(VideoGame videogame) {
		log.debug("insert videogame");
		String sql = "INSERT INTO Videogame (name,recomendedAge,launchDate,company)" + "VALUES (?, ?, ?, ?)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", videogame.getTitle());
		params.addValue("recomendedAge", videogame.getRecommendedAge());
		params.addValue("launchDate", videogame.getLaunchDate());
		params.addValue("console", videogame.getCompany());
		nameParameterdJdbcTemplate.update(sql, params);
	}
	
	@Override
	public void delete(VideoGame videogame) {
		log.debug("tablename: " +videogame.getTitle());
		String sql = "DELETE FROM " + videogame.getTitle() + " WHERE name = '?'";
		log.debug(sql);
		jdbctemplate.update(sql);
	}

	@Override
	public List<VideoGame> listAll() {
		String sql = "SELECT * FROM Videogame";
		List<VideoGame> videoGameList = beanPropertyRowMapper(sql);
		return videoGameList;
	}
	
	public Optional<Company> searchByCompany(Company company) {
		String sql = "SELECT  * FROM VIDEOGAME WHERE company = ?";
		log.debug("query: " + sql);
		company = null;
		try {
			company = jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<Company>(Company.class), company);
		} catch (EmptyResultDataAccessException e) {
			log.error("error", e);
		}
		return Optional.ofNullable(company);
	}

	public Optional<VideoGame> searchByRecommendedAge(VideoGame videogame) {
		String sql = "SELECT  * FROM VIDEOGAME WHERE" + videogame.getRecommendedAge() +"= ?";
		log.debug("query: " + sql);
		try {											
			videogame = jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<VideoGame>(VideoGame.class), videogame.getRecommendedAge());
		} catch (EmptyResultDataAccessException e) {
			log.error("error", e);
		}
		return Optional.ofNullable(videogame);
	}

	public List<VideoGame> orderByLaunchDate() {
		String sql = "SELECT * FROM Videogame ORDER BY launchDate";
		List<VideoGame> videoGameList = beanPropertyRowMapper(sql);
		return videoGameList;
	}
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public NamedParameterJdbcTemplate getNameParameterdJdbcTemplate() {
		return nameParameterdJdbcTemplate;
	}

	public void setNameParameterdJdbcTemplate(NamedParameterJdbcTemplate nameParameterdJdbcTemplate) {
		this.nameParameterdJdbcTemplate = nameParameterdJdbcTemplate;
	}
}
