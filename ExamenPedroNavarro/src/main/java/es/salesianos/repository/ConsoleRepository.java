package es.salesianos.repository;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import es.salesianos.model.Console;

@Repository
public class ConsoleRepository implements RepositoryInterface<Console> {

	private static Logger log = LogManager.getLogger(CompanyRepository.class);
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private NamedParameterJdbcTemplate nameParameterdJdbcTemplate;

	@Override
	public void insert(Console console) {
		log.debug("insert console ");
		String sql = "INSERT INTO CONSOLE (name,company)" + "VALUES (?, ?)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		params.addValue("date", console.getCompany());
		nameParameterdJdbcTemplate.update(sql, params);
	}
	
	@Override
	public void delete(Console console) {
		log.debug("tablename: " + console.getName());
		String sql = "DELETE FROM " + console.getName() + " WHERE name = '?'";
		log.debug(sql);
		jdbctemplate.update(sql);
	}

	@Override
	public List<Console> listAll() {
		String sql = "SELECT * FROM CONSOLE";
		List<Console> consoleList = beanPropertyRowMapper(sql);
		return consoleList;
	}

	public List<Console> listAllByCompany(String string) {
		String sql = "SELECT * FROM CONSOLE WHERE company = ?";
		List<Console> consoleList = beanPropertyRowMapper(sql);
		return consoleList;
	}
	
	private List beanPropertyRowMapper(String sql) {
		return jdbctemplate.query(sql, new BeanPropertyRowMapper(Console.class));
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
