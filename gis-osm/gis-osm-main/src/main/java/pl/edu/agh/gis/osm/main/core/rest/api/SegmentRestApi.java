package pl.edu.agh.gis.osm.main.core.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.main.core.logger.Logger;
import pl.edu.agh.gis.osm.main.core.service.SegmentService;

@RestController
public class SegmentRestApi {

	@Autowired
	protected SegmentService segmentService;

	@Autowired
	private Logger log;

	@RequestMapping(value = "/segment", method = RequestMethod.POST, headers = "Accept=application/json")
	public Segment create(@RequestBody Segment segment) {
		log.logSuccess(String.format("Create Segment invoked with param: %s", segment));
		return segmentService.create(segment);
	}

	@RequestMapping(value = "/segment", method = RequestMethod.GET)
	public List<Segment> getAll() {
		log.logSuccess("Get all segments invoked");
		return segmentService.getAll();
	}

	@RequestMapping(value = "/segment/{id}", method = RequestMethod.GET)
	public Segment getById(@PathVariable Integer id) {
		log.logSuccess(String.format("Get Segment by Id invoked with param: id = %s", id));
		return segmentService.getById(id);
	}

}
