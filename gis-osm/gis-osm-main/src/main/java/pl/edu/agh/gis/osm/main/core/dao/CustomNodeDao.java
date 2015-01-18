package pl.edu.agh.gis.osm.main.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.main.core.dao.mapper.CustomNodeMapper;

@Component
public class CustomNodeDao extends BaseDao {

	@Autowired
	protected CustomNodeMapper customNodeMapper;

    private final static String GET_ALL_QUERY = "SELECT * FROM custom_nodes";
    
    public List<CustomNode> getAll() {

    	List<CustomNode> customNodeList = jdbcTemplate.query(GET_ALL_QUERY, new RowMapperResultSetExtractor<CustomNode>(customNodeMapper));
    	
    	return customNodeList;
 
    }
    
    private final static String INSERT_SQL = "INSERT INTO custom_nodes(geom) VALUES(ST_SetSRID(ST_MakePoint(:lat,:lon), 4326))	";
    
    public CustomNode create(CustomNode customNode) {
    	Map<String, Object> parameters = new HashMap<>();
    	parameters.put("lat", customNode.getLat());
    	parameters.put("lon", customNode.getLon());
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	SqlParameterSource source = new MapSqlParameterSource(parameters);
    	jdbcTemplate.update(INSERT_SQL, source, keyHolder,new String[] { "id" });
    	customNode.setId(keyHolder. getKey().intValue());
    	return customNode;
    }
    
    private final static String GET_BY_ID_SQL = "SELECT * FROM custom_nodes c WHERE c.id = :id";
    
    public CustomNode getById(int id) {
    	Map<String, Object> parameteres = new HashMap<>();
    	parameteres.put("id",id);
    	CustomNode result = jdbcTemplate.queryForObject(GET_BY_ID_SQL, parameteres, customNodeMapper);
    	return result;
    }
    
}
