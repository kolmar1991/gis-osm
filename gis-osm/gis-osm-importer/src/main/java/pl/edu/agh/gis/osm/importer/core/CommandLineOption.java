package pl.edu.agh.gis.osm.importer.core;

public enum CommandLineOption {

	CLEAR("clear",false),	
	DOWNLOAD("download",false),
	POPULATE("populate",false),	
	DB_URL("dburl",true),	
	DB_NAME("dbname",true),	
	DB_USER("dbuser",true),	
	DB_PASSWORD("dbpassword",true),	
	MIN_LAT("minlat",true),	
	MAX_LAT("maxlat",true),	
	MIN_LON("minlon",true),	
	MAX_LON("maxlon",true),	
	FILENAME("filename",true),
	CHANGE_OLD("changeOld",true),
	CHANGE_NEW("changeNew",true),
	CHANGE_RESULT("changeResult",true),
	CHANGE("changeSet",false);
	
	private String text;
	private boolean hasArg;
	
	private CommandLineOption(String text,boolean hasArg) {
		this.text = text;
		this.hasArg = hasArg;
	}
	
	public String getText() {
		return text;
	}
	
	public boolean hasArg() {
		return hasArg;
	}
}
