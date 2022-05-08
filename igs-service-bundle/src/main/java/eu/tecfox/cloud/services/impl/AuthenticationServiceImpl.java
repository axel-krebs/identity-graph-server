package eu.tecfox.cloud.services.impl;

import eu.tecfox.cloud.identity.api.IdentityService;
import eu.tecfox.cloud.services.api.AuthenticationService;
import eu.tecfox.cloud.services.api.Dummy;
import eu.tecfox.cloud.services.api.UserSession;

public class AuthenticationServiceImpl implements AuthenticationService {

	IdentityService identService;

	@Override
	public UserSession authenticate(String token) {

		System.out.println("AuthenticationServiceImpl->authenticate: {}");

		return new Dummy();
	}

}
