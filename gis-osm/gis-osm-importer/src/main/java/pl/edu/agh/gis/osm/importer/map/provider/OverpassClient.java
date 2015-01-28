package pl.edu.agh.gis.osm.importer.map.provider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;

import pl.edu.agh.gis.osm.importer.core.CommandLineOption;

public class OverpassClient implements MapApiClient {

	public static String URL_TEMPLATE =  "http://overpass-api.de/api/map?bbox=%s,%s,%s,%s"; // minLon, minLat, maxLon, maxLat
	
	//FIXME metoda zabrana ze starej gamy, ogarnac to!
	
	@Override
	public void download(Map<CommandLineOption, String> parameters) {

		String url = String.format(URL_TEMPLATE, parameters.get(CommandLineOption.MIN_LON),parameters.get(CommandLineOption.MIN_LAT),parameters.get(CommandLineOption.MAX_LON),parameters.get(CommandLineOption.MAX_LAT));
		
		System.out.println(url);//FIXME logowanie
		
        URL mapServiceURL = null;
        ReadableByteChannel channel = null;
        FileOutputStream fileOutputStream = null;
        try {
            mapServiceURL = new URL(url);
            channel = Channels.newChannel(mapServiceURL.openStream());
            fileOutputStream = new FileOutputStream(parameters.get(CommandLineOption.FILENAME));
            fileOutputStream.getChannel().transferFrom(channel, 0,Long.MAX_VALUE);
        } catch (Exception e) {
            throw new RuntimeException("Unable to fetch OSM data from web server",e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException("Unable to close file output stream",e);
                }
            }
        }
		
	}

}
