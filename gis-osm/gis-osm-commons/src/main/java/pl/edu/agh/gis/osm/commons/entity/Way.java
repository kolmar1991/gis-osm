package pl.edu.agh.gis.osm.commons.entity;

import java.util.List;
import java.util.Map;

public class Way {

	private Long id;
	private Map<String, String> tags;
	private List<Long> nodeIdList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	public List<Long> getNodeIdList() {
		return nodeIdList;
	}

	public void setNodeIdList(List<Long> nodeIdList) {
		this.nodeIdList = nodeIdList;
	}

	@Override
	public String toString() {
		return "Way [id=" + id + ", tags=" + tags + ", nodeIdList=" + nodeIdList + "]";
	}

}
