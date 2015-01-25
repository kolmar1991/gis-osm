package pl.edu.agh.gis.osm.main.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.gis.osm.commons.entity.Way;
import pl.edu.agh.gis.osm.main.core.dao.WayDao;

@Component
public class WayService {

	@Autowired
	protected WayDao wayDao;

	public Way getById(Long id) {
		return wayDao.getById(id);
	}

	public List<Way> getInRadius(Double lat, Double lon, Integer radius) {
		return wayDao.getInRadius(lat, lon, radius);
	}

}
