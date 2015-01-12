package pl.edu.agh.gis.osm.main.core.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.main.core.dao.CustomNodeDao;

@RestController
public class CustomNodeService {

	private final CustomNodeDao  customNodeDao;
	
	@Autowired
	public CustomNodeService(CustomNodeDao customNodeDao) {
		this.customNodeDao = customNodeDao;
		
	}
	
	@RequestMapping(value = "/customnode/", method = RequestMethod.POST, headers = "Accept=application/json")
	public CustomNode create(@RequestBody CustomNode customNode) {
		return customNodeDao.create(customNode);
	}
	//TODO error handler generyczny dla requestow
	@RequestMapping(value = "/customnode/", method = RequestMethod.GET)
	public List<CustomNode> getAll() {
		return customNodeDao.getAll();
	}
	
	@RequestMapping(value = "/customnode/{id}", method = RequestMethod.GET)
	public CustomNode get(@PathVariable int id) {
		return null;
	}
	
	//TODO update delete
}
