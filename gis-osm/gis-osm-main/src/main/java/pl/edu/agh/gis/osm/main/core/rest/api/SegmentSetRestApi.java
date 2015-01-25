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

import pl.edu.agh.gis.osm.commons.entity.SegmentSet;
import pl.edu.agh.gis.osm.main.core.logger.Logger;
import pl.edu.agh.gis.osm.main.core.service.SegmentSetService;

@RestController
public class SegmentSetRestApi {

    @Autowired
    protected SegmentSetService segmentSetService;

	@Autowired
	private Logger log;
    
    @RequestMapping(value = "/segmentset", method = RequestMethod.POST, headers = "Accept=application/json")
    public SegmentSet create(@RequestBody SegmentSet segmentSet) {
		log.logSuccess(SourceType.MANUAL, String.format("Create SegmentSet invoked with params: %s", segmentSet));
        return segmentSetService.create(segmentSet);
    }

    @RequestMapping(value = "/segmentset", method = RequestMethod.GET)
    public List<SegmentSet> getAll() {
    	log.logSuccess(SourceType.MANUAL, "Get all segment sets invoked");
        return segmentSetService.getAll();
    }

    @RequestMapping(value = "/segmentset/{id}", method = RequestMethod.GET)
    public SegmentSet getById(@PathVariable int id) {
    	log.logSuccess(SourceType.MANUAL, String.format("Get SegmentSet by Id invoked with param: %s", id));
        return segmentSetService.getById(id);
    }
}
