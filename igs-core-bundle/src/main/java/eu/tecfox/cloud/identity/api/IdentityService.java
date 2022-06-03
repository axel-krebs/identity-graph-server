package de.akrebs.cloud.identity.api;

import org.osgi.util.promise.Promise;

public interface IdentityService {

	Promise<Identity> find(String id);

	/**
	 * Having a realm means the service identityService configured properly; compare to 'health
	 * check'..
	 * 
	 * @return
	 */
	boolean hasRealm();
}
