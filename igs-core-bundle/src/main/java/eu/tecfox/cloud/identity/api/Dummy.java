package eu.tecfox.cloud.identity.api;

public class Dummy implements Identity {

	@Override
	public Kind getKind() {
		return Kind.AVATAR;
	}

	@Override
	public SystemUniqueId getId() {
		return new SystemUniqueId() {
			
		};
	}

}
