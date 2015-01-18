package pl.edu.agh.gis.osm.main.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.gis.osm.commons.entity.CustomNode;
import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.main.core.dao.SegmentDao;

import java.util.List;

@Component
public class SegmentService {

    @Autowired
    protected SegmentDao segmentDao;

    @Autowired
    protected CustomNodeService customNodeService;

    public Segment create(Segment segment) {

        CustomNode nodeA = segment.getPointA();
        if (nodeA != null && nodeA.getId() == null ) {
            CustomNode created = customNodeService.create(nodeA);
            segment.setPointA(created);
        }
        CustomNode nodeB = segment.getPointB();
        if (nodeB != null && nodeB.getId() == null ) {
            CustomNode created = customNodeService.create(nodeB);
            segment.setPointB(created);
        }
        Segment created = segmentDao.create(segment);
        return created;

    }

    public List<Segment> getAll() {
        return segmentDao.getAll();
    }

}
