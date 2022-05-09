package eu.tecfox.cloud.identity.api;

public abstract class Person implements Identity {

	@Override
	public Kind getKind() {
		return Kind.PERSON;
	}

}
