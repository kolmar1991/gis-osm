package pl.edu.agh.gis.osm.main.core.rest.api;

import loggers.enums.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.main.core.logger.Logger;
import pl.edu.agh.gis.osm.main.core.service.SegmentService;

import java.util.List;

@RestController
public class SegmentRestApi {

    @Autowired
    protected SegmentService segmentService;

    @Autowired
	private Logger log;
    
    @RequestMapping(value = "/segment", method = RequestMethod.POST, headers = "Accept=application/json")
    public Segment create(@RequestBody Segment segment) {
		log.logSuccess(SourceType.MANUAL, String.format("Create Segment invoked with params: %s", segment));
        return segmentService.create(segment);
    }

    @RequestMapping(value = "/segment", method = RequestMethod.GET)
    public List<Segment> getAll() {
    	log.logSuccess(SourceType.MANUAL, "Get all segments invoked");
        return  segmentService.getAll();
    }

    @RequestMapping(value = "/segment/{id}", method = RequestMethod.GET)
    public Segment getById(@PathVariable Integer id) {
    	log.logSuccess(SourceType.MANUAL, String.format("Get Segment by Id invoked with param: %s", id));
        return  segmentService.getById(id);
    }

}
