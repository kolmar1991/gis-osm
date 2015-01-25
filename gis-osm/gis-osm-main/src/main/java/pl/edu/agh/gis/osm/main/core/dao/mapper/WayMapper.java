package pl.edu.agh.gis.osm.main.core.dao.mapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Way;

@Component
public class WayMapper implements RowMapper<Way> {

	@SuppressWarnings("unchecked")
	@Override
	public Way mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Way way = new Way();
		
		way.setId(resultSet.getLong("id"));
		Map<String, String> tags =  (Map<String, String>) resultSet.getObject("tags");
		way.setTags(tags);
		Array nodes = resultSet.getArray("nodes");
		Long[] nodesId = (Long[]) nodes.getArray();
		way.setNodeIdList(Arrays.asList(nodesId));
		return way;
	}

}
