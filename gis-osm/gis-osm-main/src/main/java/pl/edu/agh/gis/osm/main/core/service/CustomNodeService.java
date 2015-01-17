package pl.edu.agh.gis.osm.main.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.main.core.dao.CustomNodeDao;

@Component
public class CustomNodeService {

	@Autowired
	private CustomNodeDao  customNodeDao;
	
	public CustomNode create(CustomNode customNode) {
		return customNodeDao.create(customNode);
	}
	
	public List<CustomNode> getAll() {
		return customNodeDao.getAll();
	}
	
	public CustomNode getById(int id) {
		return customNodeDao.getById(id);
	}	
	
}
