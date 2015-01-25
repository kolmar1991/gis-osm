package pl.edu.agh.gis.osm.main.core.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.agh.gis.osm.commons.entity.Node;
import pl.edu.agh.gis.osm.main.core.service.NodeService;

@RestController
public class NodeRestApi {

	@Autowired
	private NodeService service;
	
	@RequestMapping(value = "/node/{id}", method = RequestMethod.GET)
	public Node getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	@RequestMapping(value = "/node/{lat}/{lon}/{radius}", method = RequestMethod.GET)
	public List<Node> getInRadius(@PathVariable("lat") double lat, @PathVariable("lon") double lon, @PathVariable("radius") int radius) {
		return service.getInRadius(lat, lon, radius);
	}
}
