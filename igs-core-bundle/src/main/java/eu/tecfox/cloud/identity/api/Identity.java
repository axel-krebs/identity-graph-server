package eu.tecfox.cloud.identity.api;

public interface Identity {
	
	enum Kind {
		PERSON,
		GROUP,
		AVATAR,
		PROCESS,
		NODE
	}
	
	Kind getKind();
	
	SystemUniqueId getId();
}
