package pl.edu.agh.gis.osm.commons.entity;

public class Segment {

	private Integer id;
	private CustomNode pointA;
	private CustomNode pointB;
	private Integer ordinal;
	private Integer segmentSetId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public Integer getSegmentSetId() {
		return segmentSetId;
	}

	@Override
	public String toString() {
		return "Segment [id=" + id + ", pointA=" + pointA + ", pointB=" + pointB + ", ordinal=" + ordinal + ", segmentSetId=" + segmentSetId + "]";
	}

	public void setSegmentSetId(Integer segmentSetId) {
		this.segmentSetId = segmentSetId;
	}

}
