package eu.tecfox.cloud.identity.api;

public interface Identity {
	
	enum Kind {
		USER_AGENT,
		GROUP,
		AVATAR,
		PROCESS,
		NODE
	}
	
	Kind getKind();
	
	SystemUniqueId getId();
}
