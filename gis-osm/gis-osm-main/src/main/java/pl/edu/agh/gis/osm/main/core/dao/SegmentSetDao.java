package pl.edu.agh.gis.osm.main.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SegmentSetDao {


	//TODO abstract dao i podziedziczyc
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SegmentSetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
}
