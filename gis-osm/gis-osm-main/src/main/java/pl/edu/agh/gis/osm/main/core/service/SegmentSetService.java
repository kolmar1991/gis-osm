package pl.edu.agh.gis.osm.main.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.gis.osm.commons.entity.Segment;
import pl.edu.agh.gis.osm.commons.entity.SegmentSet;
import pl.edu.agh.gis.osm.main.core.dao.SegmentSetDao;

import java.util.List;

@Component
public class SegmentSetService {

    @Autowired
    protected SegmentSetDao segmentSetDao;

    @Autowired
    protected SegmentService segmentService;

    public SegmentSet create(SegmentSet segmentSet) {
        SegmentSet savedSegmentSet = segmentSetDao.create(segmentSet);

        if (segmentSet.getSegmentList() != null && segmentSet.getSegmentList().isEmpty() == false) {
            for (Segment segment : segmentSet.getSegmentList()) {
                    segment.setSegmentSetId(savedSegmentSet.getId());
                    Segment created = segmentService.create(segment);
                    segment.setId(created.getId());
            }
        }

        return savedSegmentSet;
    }

    //Hello N + 1 query
    public List<SegmentSet> getAll() {
        List<SegmentSet> segmentSetList = segmentSetDao.getAll();
        for (SegmentSet segmentSet : segmentSetList) {
            List<Segment> segmentList = segmentService.getBySetId(segmentSet.getId());
            segmentSet.setSegmentList(segmentList);
        }
        return segmentSetList;
    }

    //Hello N + 1 query
    public SegmentSet getById(Integer id) {
        SegmentSet segmentSet = segmentSetDao.getById(id);
        List<Segment> segmentList = segmentService.getBySetId(segmentSet.getId());
        segmentSet.setSegmentList(segmentList);
        return segmentSet;
    }

}
