package eu.tecfox.cloud.services.api;

public interface AuthenticationService {

	UserSession authenticate(String token);
}
