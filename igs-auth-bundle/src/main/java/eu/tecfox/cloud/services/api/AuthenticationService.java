package eu.tecfox.cloud.services.api;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * I/F serves for OSGi discovery only (Felix registry)!
 * 
 * @author akrebs
 *
 */
public interface AuthenticationService {

	void authenticate(@Suspended AsyncResponse async, String token);
}
