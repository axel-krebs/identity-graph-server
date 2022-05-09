package eu.tecfox.cloud.identity.api;

public interface IdentityService {

	Identity find(String id);

	/**
	 * Having a realm means the service identityService configured properly; compare to 'health
	 * check'..
	 * 
	 * @return
	 */
	boolean hasRealm();
}
