package pl.edu.agh.gis.osm.commons.entity;

public class CustomNode {

	private int id;
	private double lat;
	private double lon;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "CustomNode [id=" + id + ", lat=" + lat + ", lon=" + lon + "]";
	}

}
