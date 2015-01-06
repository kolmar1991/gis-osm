package pl.edu.agh.gis.osm.importer.core;

import org.apache.commons.cli.Options;

public class CommandLineOptionsGenerator {

	@SuppressWarnings("static-access")
	public static Options createOptions() {
		
		Options options = new Options();

		for(CommandLineOption clOption : CommandLineOption.values()) {
			options.addOption(clOption.getText(),clOption.hasArg(),clOption.getText());		
		}
		
		return options;
		
	}
	
}
