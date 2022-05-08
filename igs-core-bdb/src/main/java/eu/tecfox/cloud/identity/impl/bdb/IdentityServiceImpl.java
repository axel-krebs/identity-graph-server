package eu.tecfox.cloud.identity.impl.bdb;

import eu.tecfox.cloud.identity.api.Identity;
import eu.tecfox.cloud.identity.api.IdentityService;

public class IdentityServiceImpl implements IdentityService {
	
	enum ServerRole {
		MASTER("master"),
		REPLICA("replica");
		private String identifier;
		private ServerRole(String name) {
			this.identifier = name;
		}
		public String getIdentifier() {
			return identifier;
		}
		public static ServerRole fromString(String s) {
			return MASTER;
		}
	}
	
	private ServerRole role;
	
	public void setRole(String role) {
		this.role = ServerRole.fromString(role);
		System.out.println("IdentityServiceImpl->setRole('" + this.role + "')");
	}

	public String getRole() {
		return role.getIdentifier();
	}

	@Override
	public Identity find(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
