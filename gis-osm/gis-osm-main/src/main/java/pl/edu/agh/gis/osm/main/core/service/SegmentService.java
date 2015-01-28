package pl.edu.agh.gis.osm.main.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.main.core.dao.SegmentDao;
import pl.edu.agh.gis.osm.main.core.logger.Logger;

import java.util.List;

@Component
public class SegmentService {

    @Autowired
    protected SegmentDao segmentDao;

    @Autowired
    protected CustomNodeService customNodeService;

    @Autowired
    protected Logger log;
    
    public Segment create(Segment segment) {

        CustomNode nodeA = segment.getPointA();
        if (nodeA != null && nodeA.getId() == null ) {
        	CustomNode created = customNodeService.create(nodeA);
            segment.setPointA(created);
        } else {
        	segment.setPointA(nodeA);
		}
       
        
        CustomNode nodeB = segment.getPointB();
        if (nodeB != null && nodeB.getId() == null ) {
            CustomNode created = customNodeService.create(nodeB);
            segment.setPointB(created);
        } else {
			segment.setPointB(nodeB);
		}
        
        Segment created = segmentDao.create(segment);
        
        log.logSuccess(String.format("CustomNode with id = %s added to segment with id = %s as PointA", segment.getPointA().getId(),segment.getId()));
        log.logSuccess(String.format("CustomNode with id = %s added to segment with id = %s as PointB", segment.getPointB().getId(),segment.getId()));
        
        return created;

    }

    public List<Segment> getAll() {
        return segmentDao.getAll();
    }

    public  Segment getById(Integer id) {
        return segmentDao.getById(id);
    }

    public List<Segment> getBySetId(Integer setId) {
        return segmentDao.getBySetId(setId);
    }

}
