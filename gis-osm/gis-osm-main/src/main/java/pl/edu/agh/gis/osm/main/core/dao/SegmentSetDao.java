package pl.edu.agh.gis.osm.main.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import pl.edu.agh.gis.osm.commons.entity.SegmentSet;
import pl.edu.agh.gis.osm.main.core.dao.mapper.SegmentSetMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class SegmentSetDao extends BaseDao {

    @Autowired
    protected SegmentSetMapper segmentSetMapper;

    protected static final String INSERT_SQL = "INSERT INTO segment_set(metadata) VALUES(:metadata)";

	public SegmentSet create(SegmentSet segmentSet) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("metadata",segmentSet.getMetadata());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource source = new MapSqlParameterSource(parameters);
        jdbcTemplate.update(INSERT_SQL, source, keyHolder,new String[] { "segment_set_id" });
        segmentSet.setId(keyHolder. getKey().intValue());
        return segmentSet;
    }

    protected  static final String GET_ALL_SQL = "SELECT * FROM segment_set";

    public List<SegmentSet> getAll() {
        List<SegmentSet> segmentSetList = jdbcTemplate.query(GET_ALL_SQL, new RowMapperResultSetExtractor<SegmentSet>(segmentSetMapper));
        return segmentSetList;
    }

    protected  static final String GET_BY_ID_SQL = "SELECT * FROM segment_set s WHERE s.segment_set_id = :id";

    public SegmentSet getById(Integer id) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("id",id);
        SegmentSet segmentSet = jdbcTemplate.queryForObject(GET_BY_ID_SQL,parameters,segmentSetMapper);
        return segmentSet;
    }



}
