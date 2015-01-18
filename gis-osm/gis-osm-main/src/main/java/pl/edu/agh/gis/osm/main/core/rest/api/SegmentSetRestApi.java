package pl.edu.agh.gis.osm.main.core.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.commons.entity.SegmentSet;
import pl.edu.agh.gis.osm.main.core.service.SegmentSetService;

import java.util.List;

@RestController
public class SegmentSetRestApi {

    @Autowired
    protected SegmentSetService segmentSetService;


    @RequestMapping(value = "/segmentset", method = RequestMethod.POST, headers = "Accept=application/json")
    public SegmentSet create(@RequestBody SegmentSet segmentSet) {
        return segmentSetService.create(segmentSet);
    }

    @RequestMapping(value = "/segmentset", method = RequestMethod.GET)
    public List<SegmentSet> getAll() {
        return segmentSetService.getAll();
    }

    @RequestMapping(value = "/segmentset/{id}", method = RequestMethod.GET)
    public SegmentSet getById(@PathVariable int id) {
        return segmentSetService.getById(id);
    }
}
