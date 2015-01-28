package pl.edu.agh.gis.osm.main.core.rest.api.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.gis.osm.main.core.logger.Logger;


@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	protected Logger log;
	
	@ExceptionHandler(value = {Exception.class, RuntimeException.class})
	public @ResponseBody String handleException(Exception e) {
		log.logFailure(String.format("Error occured: %s", e));
		e.printStackTrace();
		return "Error occured"; 
	}
	
}
