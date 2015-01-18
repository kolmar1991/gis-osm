package pl.edu.agh.gis.osm.main.core.dao.mapper;

import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.commons.entity.Segment;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SegmentCustomNodeExtractor implements ResultSetExtractor<List<Segment>> {

    @Override
    public List<Segment> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Integer,Segment> segmentMap = new HashMap<>();

        while(resultSet.next()) {
            Integer segmentId = resultSet.getInt("segment_id");
            Segment segment = segmentMap.get(segmentId);
            if (segment == null) {
                segment = new Segment();
                segment.setId(segmentId);
                segment.setOrdinal(resultSet.getInt("ordinal"));
                segment.setSegmentSetId(resultSet.getInt("set_id"));
                segmentMap.put(segmentId,segment);
            }
            if (hasColumn(resultSet,"custom_node_id") == true) {
                Integer customNodeId = resultSet.getInt("custom_node_id");
                Integer idPointA = resultSet.getInt("point_a");
                Integer idPointB = resultSet.getInt("point_b");
                CustomNode customNode = new CustomNode();
                customNode.setId(customNodeId);
                PGgeometry geom = (PGgeometry) resultSet.getObject("geom");
                Point point = geom.getGeometry().getFirstPoint();
                customNode.setLat(point.x);//FIXME ktore to x a ktore y
                customNode.setLon(point.y);
                if (customNodeId == idPointA) {
                    segment.setPointA(customNode);
                } else if (customNodeId == idPointB) {
                    segment.setPointB(customNode);
                }
            }
        }
        return new ArrayList<>(segmentMap.values());
    }

    private boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        for (int x = 1; x <= columns; x++) {
            if (columnName.equals(rsmd.getColumnName(x))) {
                return true;
            }
        }
        return false;
    }

}
