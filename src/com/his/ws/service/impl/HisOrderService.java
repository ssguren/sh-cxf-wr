package com.his.ws.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.FinalParam;
import com.his.ws.BaseWebService;
import com.his.ws.service.IHisOrderService;
import com.model.db.Order;
import com.model.db.Patient;
import com.model.db.PatientCard;
import com.model.ws.DepartmentInfo;
import com.model.ws.WSResult;
import com.model.ws.rs.DepartmentsResult;
import com.model.ws.rs.DoctorResult;
import com.model.ws.rs.DoctorsResult;
import com.model.ws.rs.OrderInfo;
import com.model.ws.rs.ScheduleResult;
import com.servicecenter.service.db.IDepartmentService;
import com.servicecenter.service.db.IDoctorScheduleService;
import com.servicecenter.service.db.IDoctorService;
import com.servicecenter.service.db.IOrderService;
import com.servicecenter.service.db.IPatientCardService;
import com.servicecenter.service.db.IPatientService;
import com.utils.StringUtil;

@Service
@Scope("prototype")
@WebService(serviceName = "HisOrderService", portName = "HisOrderServicePort", targetNamespace = "http://tempuri.org", endpointInterface = "com.his.ws.service.IHisOrderService")
public class HisOrderService extends BaseWebService implements IHisOrderService {

	@Resource
	private IDoctorScheduleService doctorScheduleService;

	@Resource
	private IPatientCardService patientCardService;

	@Resource
	private IDepartmentService departmentService;

	@Resource
	private IPatientService patientService;

	@Resource
	private IDoctorService doctorService;

	@Resource
	private IOrderService orderService;

	private final static Logger log = Logger.getLogger(HisOrderService.class);

	public DepartmentsResult getDepartments(String deptId) {
		List<DepartmentInfo> deptInfoList = new ArrayList<DepartmentInfo>();
		DepartmentsResult deptResult = new DepartmentsResult();
		// TODO
		return deptResult;
	}

	public DoctorResult getDoctor(String doctorId) {
		DoctorResult result = new DoctorResult();
		// TODO
		return result;
	}

	public DoctorsResult getDoctors(String deptId) {
		DoctorsResult result = new DoctorsResult();
		// TODO
		log.info("getDoctors: " + result.getMsg());
		return result;
	}

	public ScheduleResult getSchedule(String departmentId, String doctorId,
			String beginDate, String endDate, String aucode) {
		// TODO
		return null;
	}

	public WSResult cancelOrder(String orderNum) {
		log.info("cancel order start and orderNum : " + orderNum);
		// TODO
		return null;
	}

	public OrderInfo orderRegist(String phoneNumber, String hospitalId,
			String departmentId, String doctorId, String schId, String regId,
			String reserveDate, String reserveTime, String idType,
			String idCode, String patientName, String cardNum, String aucode) {
		log.info("orderRegist start:<<" + "phoneNumber:" + phoneNumber
				+ ",hospitalId:" + hospitalId + ",departmentId:" + departmentId
				+ ",doctorId:" + doctorId + ",schId:" + schId + ",regId:"
				+ regId + ",reserveDate:" + reserveDate + ",reserveTime:"
				+ reserveTime + ",idType:" + idType + ",idCode:" + idCode
				+ ",patientName:" + patientName + ",cardNum:" + cardNum
				+ ",aucode:" + aucode + ">>");
		OrderInfo res = new OrderInfo();
		try {

			// 检查参数是否完备
			if (!StringUtil.isEmptyStr(schId)
					|| !StringUtil.isEmptyStr(reserveDate)
					|| !StringUtil.isEmptyStr(reserveTime)
					|| !StringUtil.isEmptyStr(doctorId)
					|| !StringUtil.isEmptyStr(departmentId)) {
				// TODO
			} else {
				res.setMsg("排班信息不完整!");
				res.setResultCode(FinalParam.WSRESULT_CODE_SCHEDULE_ERROR);
			}
			log.info("orderRegist result:" + res.getMsg());
		} catch (Exception e) {
			log.info(e);
			res.setMsg(e.toString());
			res.setResultCode(FinalParam.WSRESULT_CODE_OTHER_ERROR);
			e.printStackTrace();
		}
		return res;
	}

	private Patient isVerifyPatient(String cardNum, String patientName) {
		String[] num = cardNum.split("-");
		if (num.length > 1) {
			if (num[0].equals(FinalParam.INSURANCE_CARD) && num[1].length() > 7) {
				PatientCard pc = patientCardService.findByCardNum(num[1]
						.substring(0, 8));
				if (null != pc.getBrid()) {
					Patient person = patientService.findByBrid(pc.getBrid()
							.longValue());
					if (null != person && person.getBrxm().equals(patientName)) {
						return person;
					}
				}
			} else if (num[0].equals(FinalParam.MEDICARE_CARD)) {
				List<Patient> patientList = patientService
						.findByNameAndCardNum(patientName, num[1]);
				if (null != patientList && patientList.size() > 0) {
					return patientList.get(0);
				}
			}
		}
		return null;
	}

	private Order isReOrder(String departmentId, Long patientId,
			String reserveDate) {
		Order tmp = new Order();
		String startTime = reserveDate.concat(" 00:00:00");
		String endTime = reserveDate.concat(" 23:59:59");
		List<Order> orderList = orderService.findByOrderParam(departmentId,
				patientId, Timestamp.valueOf(startTime),
				Timestamp.valueOf(endTime), FinalParam.ORDER_STATUS_VALID);
		if (null != orderList && orderList.size() > 0) {
			tmp = orderList.get(0);
		}
		return tmp;
	}

}
