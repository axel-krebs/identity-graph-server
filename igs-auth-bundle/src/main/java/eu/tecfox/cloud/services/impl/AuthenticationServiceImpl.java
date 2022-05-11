package eu.tecfox.cloud.services.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;
import org.osgi.util.promise.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.osgi.HazelcastOSGiInstance;
import com.hazelcast.osgi.HazelcastOSGiService;

import eu.tecfox.cloud.identity.api.Identity;
import eu.tecfox.cloud.identity.api.IdentityService;
import eu.tecfox.cloud.services.api.AuthenticationService;

@Component(service = AuthenticationService.class, scope = ServiceScope.PROTOTYPE)
@JaxrsResource()
public class AuthenticationServiceImpl implements AuthenticationService {

	Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	IdentityService identService;

	HazelcastOSGiService hcCacheService;

	@Override
	@GET
	@Path("/")
	public void authenticate(@Suspended AsyncResponse async, String token) {

		log.info("Authentication-Request: {}", token);
		Promise<Identity> p = identService.find(token);
		p.onSuccess(v -> async.resume(v)).onFailure(t -> async.resume(t));
	}

	public void bindHazelcastService(HazelcastOSGiService hcServices, Map props) {
		this.hcCacheService = hcServices;
		Set<HazelcastOSGiInstance> hcInstances = this.hcCacheService.getAllHazelcastInstances();
		log.debug("#### Hazelcast instances: ");
		for (Iterator<HazelcastOSGiInstance> iterator = hcInstances.iterator(); iterator.hasNext();) {
			HazelcastOSGiInstance instance = iterator.next();
			log.debug("Instance: " + instance.getName());
		}
	}

	public void unbindHazelcastService(HazelcastOSGiService tradeServices, Map props) {

		log.debug("AuthenticationServiceImpl->unbindHazelcastService()");

		this.hcCacheService = null;
	}

}
