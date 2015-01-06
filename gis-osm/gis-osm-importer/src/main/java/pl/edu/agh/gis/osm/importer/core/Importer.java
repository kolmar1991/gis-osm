package pl.edu.agh.gis.osm.importer.core;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import pl.edu.agh.gis.osm.importer.dao.GisOsmDao;
import pl.edu.agh.gis.osm.importer.map.provider.MapProvider;
import pl.edu.agh.gis.osm.importer.osmosis.OsmosisStarter;

public class Importer {

	public static void main(String[] args) {
		Importer importer = new Importer();
		importer.start(args);
	}

	public void start(String[] args) {

		Options options = CommandLineOptionsGenerator.createOptions();

		CommandLineParser commandLineParser = new BasicParser();

		CommandLine commandLine = null;
		
		try {
			commandLine = commandLineParser.parse(options, args);
		} catch (ParseException e) {
			//FIXME logger i ogarnac handlowanie bledow
			System.err.println("Error while parsing command line arguments");
			e.printStackTrace();
			System.exit(-1);
		}
		
		if (commandLine.hasOption(CommandLineOptions.CLEAR) == true) {
			GisOsmDao dao = new GisOsmDao();
			dao.clearTables();
		}
		
		if (commandLine.hasOption(CommandLineOptions.DOWNLOAD) == true) {
			MapProvider mapProvider = new MapProvider();
			mapProvider.downloadMap();
		}
 
		if (commandLine.hasOption(CommandLineOptions.POPULATE) == true) {
			OsmosisStarter starter = new OsmosisStarter();
			starter.populate();
		}
		
	}

}
