package de.akrebs.cloud.sample.search.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsApplicationSelect;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.akrebs.cloud.sample.search.api.Document;
import de.akrebs.cloud.sample.search.api.SearchService;

@Component(service = SearchService.class, scope = ServiceScope.PROTOTYPE)
@JaxrsResource
@JaxrsApplicationSelect("(osgi.jaxrs.name=app4graph")
public class SearchServiceREST implements SearchService {

	private static final Logger LOG = LoggerFactory.getLogger(SearchServiceREST.class);

	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void search(@Suspended AsyncResponse res) {

		// Iterate list of looked-up documents

		List<Document> result = new ArrayList<>();
		Document dummy;
		try {
			dummy = new Document(1L, "Dummy", new URL("https://usw"));
			result.add(dummy);
		} catch (MalformedURLException e) {
			
			LOG.error("URL was malformed. {}", e.getMessage());
			
			res.cancel();
		}
		
		res.resume(result);
	}

}
