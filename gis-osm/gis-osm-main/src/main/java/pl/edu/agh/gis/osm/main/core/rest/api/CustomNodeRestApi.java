package pl.edu.agh.gis.osm.main.core.rest.api;

import java.util.List;

import loggers.enums.SourceType;
import loggers.impl.GisLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.main.core.service.CustomNodeService;

@RestController
public class CustomNodeRestApi {

	@Autowired
	private CustomNodeService service;
	
	//@Autowired
	private GisLogger log;
	
	@RequestMapping(value = "/customnode/", method = RequestMethod.POST, headers = "Accept=application/json")
	public CustomNode create(@RequestBody CustomNode customNode) {
		log.logSuccess(SourceType.MANUAL, String.format("Create CustomNode invoked with params: %s", customNode));
		return service.create(customNode);
	}
	
	@RequestMapping(value = "/customnode/", method = RequestMethod.GET)
	public List<CustomNode> getAll() {
		log.logSuccess(SourceType.MANUAL, "Get all custom nodes invoked");
		return service.getAll();
	}
	
	@RequestMapping(value = "/customnode/{id}", method = RequestMethod.GET)
	public CustomNode getById(@PathVariable int id) {
		log.logSuccess(SourceType.MANUAL, String.format("Get CustomNode by Id invoked with param: %s", id));
		return service.getById(id);
	}

}
