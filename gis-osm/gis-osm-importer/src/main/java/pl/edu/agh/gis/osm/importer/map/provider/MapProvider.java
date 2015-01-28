package pl.edu.agh.gis.osm.importer.map.provider;

import java.util.Map;

import pl.edu.agh.gis.osm.importer.core.CommandLineOption;

public class MapProvider {

	public void downloadMap(Map<CommandLineOption, String> parameters) {
		System.out.println("DOWNLOAD" + parameters);	//FIXME ogarnac logi i dodac drugi serwis i parametry dla wyboru
		
		MapApiClient mapApiClient = new OverpassClient();
		
		mapApiClient.download(parameters);
		
		
	}
	
}
