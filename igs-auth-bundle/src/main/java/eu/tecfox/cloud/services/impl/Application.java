package eu.tecfox.cloud.services.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.osgi.HazelcastOSGiInstance;
import com.hazelcast.osgi.HazelcastOSGiService;

import eu.tecfox.cloud.identity.api.IdentityService;

/**
 * Essentially, the 'application' is wiring & configuraing the REST service and
 * distributed cache.
 * 
 * @author akrebs
 *
 */
public class Application {

	Logger log = LoggerFactory.getLogger(Application.class);

	IdentityService identService;

	HazelcastOSGiService hcCacheService;

	public void init() {
		log.info("### Application->init()");
	}
	
	public void destroy() {
		log.info("### Application->destroy()");
	}
	
	public void bindHazelcastService(HazelcastOSGiService hcServices, Map props) {
		this.hcCacheService = hcServices;
		Set<HazelcastOSGiInstance> hcInstances = this.hcCacheService.getAllHazelcastInstances();
		
		log.debug("### Hazelcast instances: ");
		
		for (Iterator<HazelcastOSGiInstance> iterator = hcInstances.iterator(); iterator.hasNext();) {
			HazelcastOSGiInstance instance = iterator.next();
			log.debug("\tInstance: " + instance.getName());
		}
	}

	public void unbindHazelcastService(HazelcastOSGiService tradeServices, Map props) {

		log.debug("###Application->unbindHazelcastService()");

		this.hcCacheService = null;
	}

	public void bindRestletService() {

	}

	public void unbindRestletService() {

	}

}
