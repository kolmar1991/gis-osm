package pl.edu.agh.gis.osm.importer.map.provider;

import java.util.Map;

import pl.edu.agh.gis.osm.importer.core.CommandLineOption;

public class MapProvider {

	public void downloadMap(Map<CommandLineOption, String> parameters) {
		System.out.println("DOWNLOAD" + parameters);
		
	}
	
}
