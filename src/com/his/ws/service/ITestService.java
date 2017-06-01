package com.his.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.model.ws.WSResult;

@WebService(name = "TestServicePort", targetNamespace = "http://tempTest.org")
public interface ITestService {

	@WebResult(name = "WSResult", targetNamespace = "http://tempTest.org")
	@WebMethod(operationName = "isWsOk", action = "http://tempTest.org/isWsOk")
	public WSResult isWsOk();

	@WebResult(name = "WSResult", targetNamespace = "http://tempTest.org")
	@WebMethod(operationName = "dbChange", action = "http://tempTest.org/dbChange")
	public WSResult dbChange();

}
