package pl.edu.agh.gis.osm.main.core.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Node;

@Component
public class NodeMapper implements RowMapper<Node>{

	@SuppressWarnings("unchecked")
	@Override
	public Node mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Node node = new Node();
		
		node.setId((Long)(resultSet.getLong("id")));
		PGgeometry geom = (PGgeometry) resultSet.getObject("geom");
		Point point = geom.getGeometry().getFirstPoint();
		node.setLat(point.x);//FIXME ktore to x a ktore y
		node.setLon(point.y);
		Map<String, String> tags =  (Map<String, String>) resultSet.getObject("tags");
		node.setTags(tags);
		
		return node;
		
	}

}
