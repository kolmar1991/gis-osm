package pl.edu.agh.gis.osm.main.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {

	@Autowired
    @Qualifier("jdbcTemplate_gis")
    protected NamedParameterJdbcTemplate jdbcTemplate;
}
