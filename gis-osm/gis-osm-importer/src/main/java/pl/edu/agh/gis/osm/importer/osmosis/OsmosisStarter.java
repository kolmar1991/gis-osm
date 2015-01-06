package pl.edu.agh.gis.osm.importer.osmosis;

import java.util.Map;

import pl.edu.agh.gis.osm.importer.core.CommandLineOption;

public class OsmosisStarter {

	public void populate(Map<CommandLineOption, String> parameters) {
		System.out.println("OSMOSIS" + parameters);
	}
	
}
