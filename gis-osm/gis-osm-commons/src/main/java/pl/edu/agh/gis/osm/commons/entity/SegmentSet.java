package pl.edu.agh.gis.osm.commons.entity;

import java.util.List;

public class SegmentSet {

	private int id;
	private String metadata;
	private List<Segment> segmentList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public List<Segment> getSegmentList() {
		return segmentList;
	}

	public void setSegmentList(List<Segment> segmentList) {
		this.segmentList = segmentList;
	}

	@Override
	public String toString() {
		return "SegmentSet [id=" + id + ", metadata=" + metadata + ", segmentList=" + segmentList + "]";
	}

}
