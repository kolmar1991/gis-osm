package pl.edu.agh.gis.osm.main.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {

	@Autowired
    protected NamedParameterJdbcTemplate jdbcTemplate;
	
}
