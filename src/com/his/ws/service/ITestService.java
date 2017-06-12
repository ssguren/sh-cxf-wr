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
	@WebMethod(operationName = "dbChangeWithoutAop", action = "http://tempTest.org/dbChangeWithoutAop")
	public WSResult dbChangeWithoutAop();

	@WebResult(name = "WSResult", targetNamespace = "http://tempTest.org")
	@WebMethod(operationName = "dbChange4Aop", action = "http://tempTest.org/dbChange4Aop")
	public WSResult dbChange4Aop();

	@WebResult(name = "WSResult", targetNamespace = "http://tempTest.org")
	@WebMethod(operationName = "testHessian", action = "http://tempTest.org/testHessian")
	public WSResult testHessian();

	@WebResult(name = "WSResult", targetNamespace = "http://tempTest.org")
	@WebMethod(operationName = "testHessianProxy", action = "http://tempTest.org/testHessianProxy")
	public WSResult testHessianProxy();

	@WebResult(name = "WSResult", targetNamespace = "http://tempTest.org")
	@WebMethod(operationName = "testAuthHessian", action = "http://tempTest.org/testAuthHessian")
	public WSResult testAuthHessian();

	@WebResult(name = "WSResult", targetNamespace = "http://tempTest.org")
	@WebMethod(operationName = "testAuthHessian4Header", action = "http://tempTest.org/testAuthHessian4Header")
	public WSResult testAuthHessian4Header();

}
