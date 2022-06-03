package de.akrebs.cloud.identity.api;

/**
 * Represents a network node.
 * 
 * @author akrebs
 *
 */
public abstract class Node implements Identity {

	@Override
	public Kind getKind() {
		return Kind.NODE;
	}

}
