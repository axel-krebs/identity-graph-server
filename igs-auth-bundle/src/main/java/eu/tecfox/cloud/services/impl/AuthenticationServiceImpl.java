package eu.tecfox.cloud.services.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.osgi.HazelcastOSGiInstance;
import com.hazelcast.osgi.HazelcastOSGiService;

import eu.tecfox.cloud.identity.api.IdentityService;
import eu.tecfox.cloud.services.api.AuthenticationService;
import eu.tecfox.cloud.services.api.Dummy;
import eu.tecfox.cloud.services.api.UserSession;

public class AuthenticationServiceImpl implements AuthenticationService {

	Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	IdentityService identService;
	
	HazelcastOSGiService hcCacheService;

	@Override
	public UserSession authenticate(String token) {

		System.out.println("AuthenticationServiceImpl->authenticate: {}");
		
		return new Dummy();
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
