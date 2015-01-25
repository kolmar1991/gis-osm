package pl.edu.agh.gis.osm.main.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Way;
import pl.edu.agh.gis.osm.main.core.dao.mapper.WayMapper;

@Component
public class WayDao extends BaseDao {

	@Autowired
	protected WayMapper wayMapper;

	public static final String GET_BY_ID_SQL = "SELECT * FROM ways w WHERE w.id = :id";

	public Way getById(Long id) {
		Map<String, Object> parameteres = new HashMap<>();
		parameteres.put("id", id);
		Way result = jdbcTemplate.queryForObject(GET_BY_ID_SQL, parameteres, wayMapper);
		return result;
	}

	public static final String GET_IN_RADIUS_SQL = "SELECT DISTINCT ON (id) * FROM (SELECT w.id,w.nodes,w.tags,unnest(w.nodes) AS unnested  FROM ways w) AS way_unnested WHERE unnested IN ( SELECT n.id FROM nodes n WHERE ST_DWithin(n.geom, ST_GeographyFromText('SRID=4326;POINT(%s %s)'),:radius ));";

	public List<Way> getInRadius(Double lat, Double lon, Integer radius) {
		// jakies problemy sa z mapowaniem parametrow do pointa
		String sql = String.format(GET_IN_RADIUS_SQL, lat, lon);
		Map<String, Object> parameteres = new HashMap<>();
		parameteres.put("radius", radius);
		List<Way> ways = jdbcTemplate.query(sql, parameteres, new RowMapperResultSetExtractor<Way>(wayMapper));
		return ways;
	}

}
