package de.akrebs.cloud.identity.api;

public abstract class Group implements Identity {

	@Override
	public Kind getKind() {
		return Kind.GROUP;
	}

}
