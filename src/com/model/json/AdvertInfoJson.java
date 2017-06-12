package com.model.json;

import java.io.Serializable;

public class AdvertInfoJson implements Serializable {

	private String id;
	private String advertName;
	private String relUrl;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdvertName() {
		return advertName;
	}

	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}

	public String getRelUrl() {
		return relUrl;
	}

	public void setRelUrl(String relUrl) {
		this.relUrl = relUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdvertInfoJson [id=" + id + ", advertName=" + advertName
				+ ", relUrl=" + relUrl + ", status=" + status + "]";
	}

}
