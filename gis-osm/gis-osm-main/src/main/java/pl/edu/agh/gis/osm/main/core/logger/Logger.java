package pl.edu.agh.gis.osm.main.core.logger;


import loggers.enums.SourceType;
import loggers.impl.GisLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"ztb7-context.xml", "applicationContext.xml"})
public class Logger {

    @Autowired
    public GisLogger log;

    public void logSuccess(String details) {
        log.logSuccess(SourceType.MANUAL, details);
    }

    public void logFailure(String detailedError){
        log.logFailure(SourceType.MANUAL, detailedError);
    }


}
