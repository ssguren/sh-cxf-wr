package com.model.ws;

public class WSResult {

	private String msg;
	private String resultCode;

	public WSResult() {
		super();
	}

	public WSResult(String msg, String resultCode) {
		this.msg = msg;
		this.resultCode = resultCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

}
