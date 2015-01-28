package pl.edu.agh.gis.osm.main.core.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pl.edu.agh.gis.osm.commons.entity.SegmentSet;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SegmentSetMapper implements RowMapper<SegmentSet> {

    @Override
    public SegmentSet mapRow(ResultSet resultSet, int i) throws SQLException {

        SegmentSet segmentSet = new SegmentSet();

        segmentSet.setId(resultSet.getInt("segment_set_id"));
        segmentSet.setMetadata(resultSet.getString("metadata"));

        return segmentSet;
    }
}
