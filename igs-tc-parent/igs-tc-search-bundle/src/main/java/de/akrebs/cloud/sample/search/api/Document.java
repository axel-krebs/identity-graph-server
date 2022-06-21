package de.akrebs.cloud.sample.search.api;

import java.net.URL;

public class Document {

	Object id;
	String title;
	URL url;

	public Document(Object id, String title, URL url) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
	}

	public Object getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

}
