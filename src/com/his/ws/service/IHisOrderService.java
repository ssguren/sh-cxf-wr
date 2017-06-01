package com.his.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.model.ws.WSResult;
import com.model.ws.rs.DepartmentsResult;
import com.model.ws.rs.DoctorResult;
import com.model.ws.rs.DoctorsResult;
import com.model.ws.rs.OrderInfo;
import com.model.ws.rs.ScheduleResult;

@WebService(name = "HisOrderServicePort", targetNamespace = "http://tempuri.org")
public interface IHisOrderService {

	@WebResult(name = "DepartmentsResult", targetNamespace = "http://tempuri.org")
	@WebMethod(operationName = "GetDepartments", action = "http://tempuri.org/GetDepartments")
	public DepartmentsResult getDepartments(
			@WebParam(name = "deptId", targetNamespace = "http://tempuri.org") String deptId);

	@WebResult(name = "DoctorsResult", targetNamespace = "http://tempuri.org")
	@WebMethod(operationName = "GetDoctors", action = "http://tempuri.org/GetDoctors")
	public DoctorsResult getDoctors(
			@WebParam(name = "deptId", targetNamespace = "http://tempuri.org") String deptId);

	@WebResult(name = "DoctorResult", targetNamespace = "http://tempuri.org")
	@WebMethod(operationName = "GetDoctor", action = "http://tempuri.org/GetDoctor")
	public DoctorResult getDoctor(
			@WebParam(name = "doctorId", targetNamespace = "http://tempuri.org") String doctorId);

	@WebResult(name = "ScheduleResult", targetNamespace = "http://tempuri.org")
	@WebMethod(operationName = "GetSchedule", action = "http://tempuri.org/GetSchedule")
	public ScheduleResult getSchedule(
			@WebParam(name = "departmentId", targetNamespace = "http://tempuri.org") String departmentId,
			@WebParam(name = "doctorId", targetNamespace = "http://tempuri.org") String doctorId,
			@WebParam(name = "beginDate", targetNamespace = "http://tempuri.org") String beginDate,
			@WebParam(name = "endDate", targetNamespace = "http://tempuri.org") String endDate,
			@WebParam(name = "aucode", targetNamespace = "http://tempuri.org") String aucode);

	@WebResult(name = "WSResult", targetNamespace = "http://tempuri.org")
	@WebMethod(operationName = "CancelOrder", action = "http://tempuri.org/CancelOrder")
	public WSResult cancelOrder(
			@WebParam(name = "orderNum", targetNamespace = "http://tempuri.org") String orderNum);

	@WebResult(name = "OrderInfo", targetNamespace = "http://tempuri.org")
	@WebMethod(operationName = "OrderRegist", action = "http://tempuri.org/OrderRegist")
	public OrderInfo orderRegist(
			@WebParam(name = "phoneNumber", targetNamespace = "http://tempuri.org") String phoneNumber,
			@WebParam(name = "hospitalId", targetNamespace = "http://tempuri.org") String hospitalId,
			@WebParam(name = "departmentId", targetNamespace = "http://tempuri.org") String departmentId,
			@WebParam(name = "doctorId", targetNamespace = "http://tempuri.org") String doctorId,
			@WebParam(name = "schId", targetNamespace = "http://tempuri.org") String schId,
			@WebParam(name = "regId", targetNamespace = "http://tempuri.org") String regId,
			@WebParam(name = "reserveDate", targetNamespace = "http://tempuri.org") String reserveDate,
			@WebParam(name = "reserveTime", targetNamespace = "http://tempuri.org") String reserveTime,
			@WebParam(name = "idType", targetNamespace = "http://tempuri.org") String idType,
			@WebParam(name = "idCode", targetNamespace = "http://tempuri.org") String idCode,
			@WebParam(name = "patientName", targetNamespace = "http://tempuri.org") String patientName,
			@WebParam(name = "cardNum", targetNamespace = "http://tempuri.org") String cardNum,
			@WebParam(name = "aucode", targetNamespace = "http://tempuri.org") String aucode);
	/*
	 * 
	 * @WebResult(name = "UserWaitingListResult", targetNamespace =
	 * "http://tempuri.org")
	 * 
	 * @WebMethod(operationName = "GetUserWaitingListInfo", action =
	 * "http://tempuri.org/getUserWaitingListInfo") public UserWaitingListResult
	 * getUserWaitingListInfo(
	 * 
	 * @WebParam(name = "orderNum", targetNamespace = "http://tempuri.org")
	 * String orderNum,
	 * 
	 * @WebParam(name = "cardNum", targetNamespace = "http://tempuri.org")
	 * String cardNum,
	 * 
	 * @WebParam(name = "idCode", targetNamespace = "http://tempuri.org") String
	 * idCode,
	 * 
	 * @WebParam(name = "sequence", targetNamespace = "http://tempuri.org")
	 * String sequence,
	 * 
	 * @WebParam(name = "aucode", targetNamespace = "http://tempuri.org") String
	 * aucode);
	 */

	// -------------测试HQL-----------------------
	// @WebResult(name = "WSResult", targetNamespace = "http://tempuri.org")
	// @WebMethod(operationName = "FindAllDepartment", action =
	// "http://tempuri.org/CancelOrder")
	// public WSResult findAllDepartment();

}
