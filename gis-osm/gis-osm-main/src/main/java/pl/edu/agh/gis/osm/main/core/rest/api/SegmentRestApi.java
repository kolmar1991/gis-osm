package pl.edu.agh.gis.osm.main.core.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.main.core.service.SegmentService;

import java.util.List;

@RestController
public class SegmentRestApi {

    @Autowired
    protected SegmentService segmentService;

    @RequestMapping(value = "/segment", method = RequestMethod.POST, headers = "Accept=application/json")
    public Segment create(@RequestBody Segment segment) {
        return segmentService.create(segment);
    }

    @RequestMapping(value = "/segment", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<Segment> getAll() {
        return  segmentService.getAll();
    }


}
