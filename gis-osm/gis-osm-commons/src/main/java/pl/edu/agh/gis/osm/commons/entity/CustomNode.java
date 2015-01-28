package pl.edu.agh.gis.osm.commons.entity;

public class CustomNode {

	private Integer id;
	private Double lat;
	private Double lon;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "CustomNode [id=" + id + ", lat=" + lat + ", lon=" + lon + "]";
	}

}
