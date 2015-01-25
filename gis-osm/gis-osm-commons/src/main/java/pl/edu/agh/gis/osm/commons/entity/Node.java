package pl.edu.agh.gis.osm.commons.entity;

import java.util.Map;

public class Node {

	private Long id;
	private Double lat;
	private Double lon;
	private Map<String, String> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", lat=" + lat + ", lon=" + lon + ", tags=" + tags + "]";
	}

}
