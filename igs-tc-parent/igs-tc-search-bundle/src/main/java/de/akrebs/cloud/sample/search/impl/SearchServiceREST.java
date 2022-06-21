package de.akrebs.cloud.sample.search.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.akrebs.cloud.sample.search.api.Document;
import de.akrebs.cloud.sample.search.api.SearchService;

@Component(service = SearchService.class)
@JaxrsResource
@Produces(MediaType.APPLICATION_JSON)
public class SearchServiceREST implements SearchService {

	private static final Logger LOG = LoggerFactory.getLogger(SearchServiceREST.class);
	
	@GET
	@Path("/find")
	@Override
	public List<Document> search() {

		// Iterate list of looked-up documents

		List<Document> res = new ArrayList<>();
		Document dummy;
		try {
			dummy = new Document(1L, "Dummy", new URL("https://usw"));
			res.add(dummy);
		} catch (MalformedURLException e) {
			
			LOG.error("URL was maformed. {}", e.getMessage());
		}

		return res;
	}

}
