package pl.edu.agh.gis.osm.importer.map.provider;

import java.util.Map;

import pl.edu.agh.gis.osm.importer.common.ExecutionStatus;
import pl.edu.agh.gis.osm.importer.core.CommandLineOption;

public interface MapApiClient {

	public void download(Map<CommandLineOption, String> parameters);
	
}
