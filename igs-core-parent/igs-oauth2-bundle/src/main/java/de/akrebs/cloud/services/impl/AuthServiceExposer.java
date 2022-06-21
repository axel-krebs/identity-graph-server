package de.akrebs.cloud.services.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.osgi.HazelcastOSGiInstance;
import com.hazelcast.osgi.HazelcastOSGiService;

import de.akrebs.cloud.identity.api.IdentityService;

/**
 * Essentially, the 'application' is wiring & configuraing the REST service and
 * distributed cache.
 * 
 * @author akrebs
 *
 */
public class AuthServiceExposer {

	Logger log = LoggerFactory.getLogger(AuthServiceExposer.class);

	IdentityService identService;

	HazelcastOSGiService hcCacheService;

	public void init() {
		log.info("### AuthServiceExposer->init()");
	}
	
	public void destroy() {
		log.info("### AuthServiceExposer->destroy()");
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

}
