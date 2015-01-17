package pl.edu.agh.gis.osm.main.core.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.CustomNode;

@Component
public class CustomNodeMapper implements RowMapper<CustomNode>{

	public CustomNode mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			
		CustomNode customNode = new CustomNode();
		
		customNode.setId((Integer)(resultSet.getInt("id"))); //TODO wywalic stringi do klasy z sqlami itp
		PGgeometry geom = (PGgeometry) resultSet.getObject("geom");
		Point point = geom.getGeometry().getFirstPoint();
		customNode.setLat(point.x);//FIXME ktore to x a ktore y
		customNode.setLon(point.y);
		
		return customNode;
		
	}

}
