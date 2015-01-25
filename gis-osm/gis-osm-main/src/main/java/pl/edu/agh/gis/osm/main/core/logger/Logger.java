package pl.edu.agh.gis.osm.main.core.logger;


import loggers.enums.SourceType;
import loggers.impl.GisLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class Logger {

    public GisLogger log;

    public Logger() {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("ztb7-context.xml");
        log = springContext.getBean(GisLogger.class);
    }

    public void logSuccess(SourceType sourceType, String details) {
        log.logSuccess(sourceType, details);
    }

    public void logFailure(SourceType sourceType, String detailedError){
        log.logFailure(sourceType, detailedError);
    }


}
