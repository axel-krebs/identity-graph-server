package eu.tecfox.cloud.identity.api;

public abstract class Node implements Identity {

	@Override
	public Kind getKind() {
		return Kind.NODE;
	}

}
