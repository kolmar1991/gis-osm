package pl.edu.agh.gis.osm.main.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.main.core.dao.mapper.CustomNodeMapper;
import pl.edu.agh.gis.osm.main.core.dao.mapper.SegmentCustomNodeExtractor;

@Component
public class SegmentDao extends BaseDao {

    @Autowired
    protected CustomNodeMapper customNodeMapper;

    @Autowired
    protected SegmentCustomNodeExtractor segmentCustomNodeExtractor;

    private final  static  String INSERT_SQL = "INSERT INTO segments(point_a,point_b,ordinal,set_id) VALUES(:pointA,:pointB,:ordinal,:setId)";

	public Segment create(Segment segment) {

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("pointA",segment.getPointA() != null ? segment.getPointA().getId() : null);
        parameters.put("pointB",segment.getPointB() != null ? segment.getPointB().getId() : null);
        parameters.put("ordinal",segment.getOrdinal());
        parameters.put("setId",segment.getSegmentSetId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource source = new MapSqlParameterSource(parameters);
        jdbcTemplate.update(INSERT_SQL, source, keyHolder,new String[] { "segment_id" });
        segment.setId(keyHolder. getKey().intValue());

        return segment;
	}

    private final static String GET_BY_ID_SQL = "SELECT * FROM segments s JOIN custom_nodes cn ON s.point_a = cn.custom_node_id OR s.point_b = cn.custom_node_id WHERE s.segment_id = :segmentId";

    public Segment getById(Integer id) {
		Map<String,Object> parameters = new HashMap<>();
        parameters.put("segmentId",id);
        List<Segment> segments = jdbcTemplate.query(GET_BY_ID_SQL,parameters,segmentCustomNodeExtractor);
        return segments.size() == 1 ? segments.iterator().next() : null;
	}

    private final static String GET_ALL_SQL = "SELECT * FROM segments s JOIN custom_nodes cn ON s.point_a = cn.custom_node_id OR s.point_b = cn.custom_node_id";

    public List<Segment> getAll() {
        return jdbcTemplate.query(GET_ALL_SQL,segmentCustomNodeExtractor);
    }

    protected static final String GET_BY_SEGMENT_SET_ID_SQL = "SELECT * FROM segments s WHERE s.set_id = :set_id";

    public List<Segment> getBySetId(Integer setId) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("set_id",setId);
        List<Segment> segmentSetList = jdbcTemplate.query(GET_BY_SEGMENT_SET_ID_SQL,parameters, segmentCustomNodeExtractor);
        return segmentSetList;
    }
}
