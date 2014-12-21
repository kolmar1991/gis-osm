package pl.edu.agh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SampleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String getValues() {
        String result = jdbcTemplate.queryForObject("select lol from test where id = 1",String.class);
        return result;
    }

}
