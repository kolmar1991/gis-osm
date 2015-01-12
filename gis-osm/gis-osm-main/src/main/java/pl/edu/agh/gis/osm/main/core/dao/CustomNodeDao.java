package pl.edu.agh.gis.osm.main.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.CustomNode;

@Component
public class CustomNodeDao {
	//TODO abstract dao i podziedziczyc
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CustomNodeDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
    //TODO wywalic sqle do osobnej klasy czy cos
    private final static String GET_ALL_QUERY = "SELECT * FROM custom_nodes";
    
    
    public List<CustomNode> getAll() {
    	
    	List<CustomNode> customNodeList = new ArrayList<CustomNode>();
    	
    	List<Map<String,Object>> rows = jdbcTemplate.queryForList(GET_ALL_QUERY, new HashMap<String, Object>());
    	
    	for(Map<String, Object> row : rows ) {
    		CustomNode customNode = new CustomNode();
    		customNode.setId((Integer)(row.get("id"))); //TODO wywalic stringi do klasy z sqlami itp
    		PGgeometry geom = (PGgeometry) row.get("geom");
    		Point point = geom.getGeometry().getFirstPoint();
    		customNode.setLat(point.x);//FIXME ktore to x a ktore y
    		customNode.setLon(point.y);
    		customNodeList.add(customNode);
    	}
    	
    	
    	return customNodeList;
 
    }
    
    private final static String INSERT_SQL = "INSERT INTO custom_nodes(geom) VALUES(ST_SetSRID(ST_MakePoint(:lat,:lon), 4326))	";
    
    public CustomNode create(CustomNode customNode) {
    	Map<String, Object> parameters = new HashMap<String, Object>();
    	parameters.put("lat", customNode.getLat()); //TODO externalize key
    	parameters.put("lon", customNode.getLon());
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	SqlParameterSource source = new MapSqlParameterSource(parameters);
    	jdbcTemplate.update(INSERT_SQL, source, keyHolder,new String[] { "id" });//TODO brzydkie to
    	customNode.setId(keyHolder. getKey().intValue());//TODO to tez
    	return customNode;
    }
    
}
