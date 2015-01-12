package pl.edu.agh.gis.osm.commons.entity;

public class Segment {

	private int id;
	private CustomNode pointA;
	private CustomNode pointB;
	private int ordinal;
	private int segmentSetId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomNode getPointA() {
		return pointA;
	}

	public void setPointA(CustomNode pointA) {
		this.pointA = pointA;
	}

	public CustomNode getPointB() {
		return pointB;
	}

	public void setPointB(CustomNode pointB) {
		this.pointB = pointB;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public int getSegmentSetId() {
		return segmentSetId;
	}

	@Override
	public String toString() {
		return "Segment [id=" + id + ", pointA=" + pointA + ", pointB=" + pointB + ", ordinal=" + ordinal + ", segmentSetId=" + segmentSetId + "]";
	}

	public void setSegmentSetId(int segmentSetId) {
		this.segmentSetId = segmentSetId;
	}

}
