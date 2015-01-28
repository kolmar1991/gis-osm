package pl.edu.agh.gis.osm.main.core;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.edu.agh.gis.osm.main.core.logger.Logger;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(App.class, args);

		Logger log = ctx.getBean(Logger.class);

		int port = ((TomcatEmbeddedServletContainer) ((AnnotationConfigEmbeddedWebApplicationContext) ctx).getEmbeddedServletContainer()).getPort();

		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			log.logFailure("Unable to get ip address" + e.toString());
		}

		log.logSuccess(String.format("Application GIS-OSM started on %s:%s", ip == null ? "none" : ip.getHostAddress(), port));

	}
}
