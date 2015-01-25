package pl.edu.agh.gis.osm.main.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Node;
import pl.edu.agh.gis.osm.main.core.dao.NodeDao;

@Component
public class NodeService {

	@Autowired
	private NodeDao nodeDao;
	
	public Node getById(Long id) {
		return nodeDao.getById(id);
	}
	
	public List<Node> getInRadius(Double lat, Double lon, Integer radius) {
		return nodeDao.getInRadius(lat, lon, radius);
	}
	
}
