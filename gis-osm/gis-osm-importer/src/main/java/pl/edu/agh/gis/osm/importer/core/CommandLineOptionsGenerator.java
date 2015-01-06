package pl.edu.agh.gis.osm.importer.core;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

public class CommandLineOptionsGenerator {

	@SuppressWarnings("static-access")
	public static Options createOptions() {
		
		Options options = new Options();
		
		//TODO zamienic commandlineoptions na enuma z fajerwerkami
		Option clear = OptionBuilder.withLongOpt(CommandLineOptions.CLEAR).create();
		options.addOption(clear);
		
		Option download = OptionBuilder.withLongOpt(CommandLineOptions.DOWNLOAD).create();
		options.addOption(download);
		
		Option populate = OptionBuilder.withLongOpt(CommandLineOptions.POPULATE).create();
		options.addOption(populate);
		
		return options;
		
	}
	
}
