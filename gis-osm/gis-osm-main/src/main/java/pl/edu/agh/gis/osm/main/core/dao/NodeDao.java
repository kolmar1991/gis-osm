package pl.edu.agh.gis.osm.main.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Node;
import pl.edu.agh.gis.osm.main.core.dao.mapper.NodeMapper;
import pl.edu.agh.gis.osm.main.core.logger.Logger;

@Component
public class NodeDao extends BaseDao {

	@Autowired
	protected NodeMapper nodeMapper;

	@Autowired
	protected Logger log;

	private final static String GET_BY_ID_SQL = "SELECT * FROM nodes n WHERE n.id = :id";

	public Node getById(Long id) {
		Map<String, Object> parameteres = new HashMap<>();
		parameteres.put("id", id);
		Node result = jdbcTemplate.queryForObject(GET_BY_ID_SQL, parameteres, nodeMapper);
		log.logSuccess(String.format("Returning node with id = %s", result.getId()));
		return result;
	}

	private static final String GET_IN_RADIUS = "SELECT * FROM nodes n WHERE ST_DWithin(n.geom, ST_GeographyFromText('SRID=4326;POINT(%s %s)'), :radius )";

	public List<Node> getInRadius(Double lat, Double lon, Integer radius) {
		// jakies problemy sa z mapowaniem parametrow do pointa
		String sql = String.format(GET_IN_RADIUS, lat, lon);
		Map<String, Object> parameteres = new HashMap<>();
		parameteres.put("radius", radius);
		List<Node> nodes = jdbcTemplate.query(sql, parameteres, new RowMapperResultSetExtractor<Node>(nodeMapper));
		log.logSuccess(String.format("Returning %s nodes", nodes.size()));
		return nodes;
	}

}
