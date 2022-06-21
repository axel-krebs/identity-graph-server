package de.akrebs.cloud.services.oauth2.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.core.HazelcastInstance;

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
