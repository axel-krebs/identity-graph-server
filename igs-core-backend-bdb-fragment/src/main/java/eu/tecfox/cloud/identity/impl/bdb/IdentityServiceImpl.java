package eu.tecfox.cloud.identity.impl.bdb;

import org.osgi.util.promise.Promise;

import eu.tecfox.cloud.identity.api.Identity;
import eu.tecfox.cloud.identity.api.IdentityService;
import eu.tecfox.cloud.identity.api.Realm;

public class IdentityServiceImpl implements IdentityService {

	enum ServerRole {
		MASTER("master"), REPLICA("replica");

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
	
	private Realm realm = new Realm();

	public void setRole(String role) {
		this.role = ServerRole.fromString(role);
		System.out.println("IdentityServiceImpl->setRole('" + this.role + "')");
	}

	public String getRole() {
		return role.getIdentifier();
	}
	
	public void setRealmName(String name) {
		this.realm.setName(name);
	}
	
	public String getRealmName() {
		return this.realm.getName();
	}
	
	@Override
	public Promise<Identity> find(String id) {
		throw new RuntimeException("NIH");
	}

	@Override
	public boolean hasRealm() {
		return this.realm == null ? false
				: (this.realm.getName() != null && !this.realm.getName().equals("")) ? true : false;
	}

}
