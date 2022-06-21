package de.akrebs.cloud.services.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.core.HazelcastInstance;
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

	HazelcastInstance hcCacheService;

	public void init() {
		log.info("### AuthServiceExposer->init()");
	}

	public void destroy() {
		log.info("### AuthServiceExposer->destroy()");
	}

	public IdentityService getIdentService() {
		return identService;
	}

	public void setIdentService(IdentityService identService) {
		this.identService = identService;
	}

	public void bindHazelcastService(HazelcastInstance hcServices, Map props) {
		this.hcCacheService = hcServices;

		log.debug("### Hazelcast instance set. ");
	}

	public void unbindHazelcastService(HazelcastInstance tradeServices, Map props) {

		log.debug("###Application->unbindHazelcastService()");

		this.hcCacheService = null;
	}

}
