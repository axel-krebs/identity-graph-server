package eu.tecfox.cloud.services.impl;

import java.util.Map;

import com.hazelcast.osgi.HazelcastOSGiService;

import eu.tecfox.cloud.identity.api.IdentityService;
import eu.tecfox.cloud.services.api.AuthenticationService;
import eu.tecfox.cloud.services.api.Dummy;
import eu.tecfox.cloud.services.api.UserSession;

public class AuthenticationServiceImpl implements AuthenticationService {

	IdentityService identService;
	
	HazelcastOSGiService hcCacheService;

	@Override
	public UserSession authenticate(String token) {

		System.out.println("AuthenticationServiceImpl->authenticate: {}");

		return new Dummy();
	}
	
	public void bindHazelcastService(HazelcastOSGiService hcServices, Map props) {
		System.out.println("########Hazelcast service was bound!");
		this.hcCacheService = hcServices;
	}

	public void unbindHazelcastService(HazelcastOSGiService tradeServices, Map props) {
		System.out.println("#########Hazelcast service was unbound!");
		this.hcCacheService = null;
	}
	
}
