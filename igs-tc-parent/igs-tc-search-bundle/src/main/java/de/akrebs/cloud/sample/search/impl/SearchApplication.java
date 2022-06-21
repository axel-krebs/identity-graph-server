package de.akrebs.cloud.sample.search.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletMultipart;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsApplicationBase;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsName;

@Component(service=Application.class)
@JaxrsApplicationBase("app4graph")
@JaxrsName("app4graph")
@HttpWhiteboardServletMultipart(enabled = true)
public class SearchApplication extends Application {
	
	@Path("/")
	@GET
	public String index() {
		return "hallo, welt";
	}
}
