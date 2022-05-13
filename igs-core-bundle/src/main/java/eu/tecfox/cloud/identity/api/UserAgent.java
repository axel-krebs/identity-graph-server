package eu.tecfox.cloud.identity.api;

/**
 * Represents a software program that acts on behalf of a person.
 * 
 * @author akrebs
 *
 */
public abstract class UserAgent implements Identity {

	@Override
	public Kind getKind() {
		return Kind.USER_AGENT;
	}

}
