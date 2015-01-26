package pl.edu.agh.gis.osm.main.core.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.agh.gis.osm.commons.entity.Way;
import pl.edu.agh.gis.osm.main.core.logger.Logger;
import pl.edu.agh.gis.osm.main.core.service.WayService;

@RestController
public class WayRestApi {

	@Autowired
	protected WayService service;

	@Autowired
	protected Logger log;

	@RequestMapping(value = "/way/{id}", method = RequestMethod.GET)
	public Way getById(@PathVariable long id) {
		log.logSuccess(String.format("Get way by id invoked with param id = %s", id));
		return service.getById(id);
	}

	@RequestMapping(value = "/way/{lat}/{lon}/{radius}", method = RequestMethod.GET)
	public List<Way> getInRadius(@PathVariable("lat") double lat, @PathVariable("lon") double lon, @PathVariable("radius") int radius) {
		log.logSuccess(String.format("Get ways in radius invoked with params: lat = %s, lon = %s, radius = %s", lat, lon, radius));
		return service.getInRadius(lat, lon, radius);
	}

}
