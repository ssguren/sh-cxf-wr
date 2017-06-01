package com.his.ws;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

public abstract class BaseWebService {

	protected final Logger log = Logger.getLogger(getClass());

	protected String wsUrl;

	@PostConstruct
	public void postConstruct() {
		log.info(getClass() + " is inited!");
	}

	public String getWsUrl() {
		return wsUrl;
	}

	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
		log.info("wsUrl set to: " + this.wsUrl);
	}
}
