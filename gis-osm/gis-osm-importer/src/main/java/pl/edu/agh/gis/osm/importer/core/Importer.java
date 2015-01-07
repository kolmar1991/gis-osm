package pl.edu.agh.gis.osm.importer.core;

import java.util.HashMap;
import java.util.Map;

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

	private CommandLine commandLine;
	
	public void start(String[] args) {

		Options options = CommandLineOptionsGenerator.createOptions();

		CommandLineParser commandLineParser = new BasicParser();
		
		try {
			commandLine = commandLineParser.parse(options, args);
		} catch (ParseException e) {
			//FIXME logger i ogarnac handlowanie bledow
			//FIXME wywraca sie na nieznanych paramterach, chyba nie powinien
			System.err.println("Error while parsing command line arguments");
			e.printStackTrace();
		}
		
		if (commandLine.hasOption(CommandLineOption.CLEAR.getText()) == true) {
			Map<CommandLineOption, String> parameters = extractArguments(CommandLineOption.DB_NAME,CommandLineOption.DB_PASSWORD,CommandLineOption.DB_USER,CommandLineOption.DB_URL);
			GisOsmDao dao = new GisOsmDao();
			dao.clearTables(parameters);
		}
		
		if (commandLine.hasOption(CommandLineOption.DOWNLOAD.getText()) == true) {
			Map<CommandLineOption, String> parameters = extractArguments(CommandLineOption.FILENAME,CommandLineOption.MAX_LAT,CommandLineOption.MAX_LON,CommandLineOption.MIN_LAT,CommandLineOption.MIN_LON);
			MapProvider mapProvider = new MapProvider();
			mapProvider.downloadMap(parameters);
		}
 
		if (commandLine.hasOption(CommandLineOption.POPULATE.getText()) == true) {
			Map<CommandLineOption, String> parameters = extractArguments(CommandLineOption.FILENAME,CommandLineOption.DB_NAME,CommandLineOption.DB_PASSWORD,CommandLineOption.DB_USER,CommandLineOption.DB_URL);
			OsmosisStarter starter = new OsmosisStarter();
			starter.populateDb(parameters);
		}
		
	}
	
	private Map<CommandLineOption, String> extractArguments(CommandLineOption... options) {
		Map<CommandLineOption, String> map = new HashMap<>();
		for (CommandLineOption option : options) {
			if (commandLine.hasOption(option.getText()) == false) {
				//FIXME logger i handlowanie bledow
				System.err.println("Missing parameter: " + option.getText());
				System.exit(-1);
			} else {
				String value = commandLine.getOptionValue(option.getText());
				map.put(option, value);
			}
		}
		return map;
	}
	

}
