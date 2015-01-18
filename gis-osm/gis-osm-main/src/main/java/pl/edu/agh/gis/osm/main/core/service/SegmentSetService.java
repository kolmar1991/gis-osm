package pl.edu.agh.gis.osm.main.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.gis.osm.commons.entity.SegmentSet;
import pl.edu.agh.gis.osm.main.core.dao.SegmentSetDao;

import java.util.List;

public class SegmentSetService {

    @Autowired
    protected SegmentSetDao segmentSetDao;

    public SegmentSet create(SegmentSet segmentSet) {
        return segmentSetDao.create(segmentSet);
    }

    public List<SegmentSet> getAll() {
        return segmentSetDao.getAll();
    }

    public SegmentSet getById(Integer id) {
        return segmentSetDao.getById(id);
    }

}
