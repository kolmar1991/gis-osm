package pl.edu.agh.gis.osm.importer.osmosis;

import java.io.File;
import java.util.Map;

import org.openstreetmap.osmosis.core.database.DatabaseLoginCredentials;
import org.openstreetmap.osmosis.core.database.DatabasePreferences;
import org.openstreetmap.osmosis.core.database.DatabaseType;
import org.openstreetmap.osmosis.pgsnapshot.common.NodeLocationStoreType;
import org.openstreetmap.osmosis.pgsnapshot.v0_6.PostgreSqlCopyWriter;
import org.openstreetmap.osmosis.xml.common.CompressionMethod;
import org.openstreetmap.osmosis.xml.v0_6.XmlReader;

import pl.edu.agh.gis.osm.importer.core.CommandLineOption;

public class OsmosisStarter {

	public void populateDb(Map<CommandLineOption, String> parameters) {
		//FIXME logowanie
		System.out.println("OSMOSIS" + parameters);
		
		XmlReader xmlReader = new XmlReader(new File(parameters.get(CommandLineOption.FILENAME)), true, CompressionMethod.None);
		DatabaseLoginCredentials databaseLoginCredentials = new DatabaseLoginCredentials(parameters.get(CommandLineOption.DB_URL), parameters.get(CommandLineOption.DB_NAME), parameters.get(CommandLineOption.DB_USER), parameters.get(CommandLineOption.DB_PASSWORD), false, false,DatabaseType.POSTGRESQL);
		DatabasePreferences databasePreferences = new DatabasePreferences(true, false);
		PostgreSqlCopyWriter copyWriter = new PostgreSqlCopyWriter(databaseLoginCredentials, databasePreferences, NodeLocationStoreType.CompactTempFile, true);
		xmlReader.setSink(copyWriter);
		xmlReader.run();
		
	}
	
}
