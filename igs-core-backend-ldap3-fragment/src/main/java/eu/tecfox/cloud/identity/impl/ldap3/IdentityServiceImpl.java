package eu.tecfox.cloud.identity.impl.ldap3;

import org.osgi.util.promise.Promise;

import eu.tecfox.cloud.identity.api.Identity;
import eu.tecfox.cloud.identity.api.IdentityService;

public class IdentityServiceImpl implements IdentityService {

	@Override
	public Promise<Identity> find(String id) {
		throw new RuntimeException("NIH");
	}

	@Override
	public boolean hasRealm() {
		// TODO Auto-generated method stub
		return false;
	}

}
