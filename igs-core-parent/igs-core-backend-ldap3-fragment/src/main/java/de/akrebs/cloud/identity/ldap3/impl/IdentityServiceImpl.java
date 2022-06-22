package de.akrebs.cloud.identity.ldap3.impl;

import org.osgi.util.promise.Promise;

import de.akrebs.cloud.identity.api.Identity;
import de.akrebs.cloud.identity.api.IdentityService;

public class IdentityServiceImpl implements IdentityService {

	String hostName;
	
	@Override
	public Promise<Identity> find(String id) {
		throw new RuntimeException("NIH");
	}

	@Override
	public boolean hasRealm() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
