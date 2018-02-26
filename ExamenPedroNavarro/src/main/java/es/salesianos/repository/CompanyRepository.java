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
import es.salesianos.model.Company;


@Repository
public class CompanyRepository implements RepositoryInterface<Company> {
	
	private static Logger log = LogManager.getLogger(CompanyRepository.class);
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private NamedParameterJdbcTemplate nameParameterdJdbcTemplate;

	@Override
	public void insert(Company company) {
		log.debug("insert company");
		String sql = "INSERT INTO Company (name,date)" + "VALUES (?, ?)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", company.getName());
		params.addValue("date", company.getDate());
		nameParameterdJdbcTemplate.update(sql, params);
	}
	
	@Override
	public void delete(Company company) {
		log.debug("tablename: " + company.getName());
		String sql = "DELETE FROM " + company.getName() + " WHERE name = '?'";
		log.debug(sql);
		jdbctemplate.update(sql);
	}

	@Override
	public List<Company> listAll() {
		String sql = "SELECT * FROM COMPANY";
		List<Company> companyList = jdbctemplate.query(sql, new BeanPropertyRowMapper(Company.class));
		return companyList;
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
