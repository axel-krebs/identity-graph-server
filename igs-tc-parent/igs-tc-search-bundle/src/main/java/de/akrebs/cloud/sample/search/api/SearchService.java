package de.akrebs.cloud.sample.search.api;

import javax.ws.rs.container.AsyncResponse;

public interface SearchService {

	public void search(AsyncResponse res);
	
}
