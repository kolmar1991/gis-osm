package pl.edu.agh.gis.osm.main.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.main.core.dao.mapper.CustomNodeMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class SegmentDao extends BaseDao {

    @Autowired
    protected CustomNodeMapper customNodeMapper;

    private final  static  String INSERT_SQL = "INSERT INTO segments(point_a,point_b,ordinal,set_id) VALUES(:pointA,:pointB,:ordinal,:setId)";

	public Segment create(Segment segment) {

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("pointA",segment.getPointA() != null ? segment.getPointA().getId() : null);
        parameters.put("pointB",segment.getPointB() != null ? segment.getPointB().getId() : null);
        parameters.put("ordinal",segment.getOrdinal());
        parameters.put("setId",segment.getSegmentSetId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource source = new MapSqlParameterSource(parameters);
        jdbcTemplate.update(INSERT_SQL, source, keyHolder,new String[] { "id" });
        segment.setId(keyHolder. getKey().intValue());

        return segment;
	}

	public Segment getById(Segment segment) {
		return null;
	}

    private final static String GET_ALL_SQL = "SELECT * FROM segments s JOIN custom_nodes cn ON s.point_a = cn.id";

    public List<Segment> getAll() {
        return jdbcTemplate.query(GET_ALL_SQL,new ResultSetExtractor<List<Segment>>() {
            Map<Integer,Segment> segmentMap = new HashMap<>();

            @Override
            public List<Segment> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                return null ;
            }
        });
    }
	
}
