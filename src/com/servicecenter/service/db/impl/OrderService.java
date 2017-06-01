package com.servicecenter.service.db.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.IOrderDAO;
import com.model.db.Order;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IOrderService;

@Service
@Transactional(readOnly = false)
public class OrderService extends DAOBasedService<Order, Integer, IOrderDAO>
		implements IOrderService {

	@Override
	public Order findById(Integer id) {
		if (dao != null)
			return dao.findById(id);
		return null;
	}

	public List<Order> findByDoctorAndTime(String doctorId,
			Timestamp beginTime, Timestamp endTime) {
		if (dao != null)
			return dao.findByDoctorAndTime(doctorId, beginTime, endTime);
		return null;
	}

	public List<Order> findByDoctorAndTime(String doctorId, String beginTime,
			String endTime) {
		if (dao != null)
			return dao.findByDoctorAndTime(doctorId, Timestamp
					.valueOf(beginTime), Timestamp.valueOf(endTime));
		return null;
	}

	public List<Order> findByPatientId(String patientId) {
		if (dao != null)
			return dao.findByPatientId(patientId);
		return null;
	}

	public List<Order> findByOrderParam(String doctorId, Timestamp beginTime,
			Timestamp endTime, String regId) {
		if (dao != null)
			return dao.findByOrderParam(doctorId, beginTime, endTime, regId);
		return null;
	}

	public String findOrderNumByOrder(Order order) {
		if (dao != null)
			return dao.findOrderNumByOrder(order);
		return null;
	}

	public List<String> findAllDepartment() {
		if (dao != null)
			return dao.findAllDepartment();
		return null;
	}

	public List<Order> findWaitingListByParam(String doctorId,
			Timestamp beginTime, Timestamp endTime, String regId) {
		if (dao != null)
			return dao.findWaitingListByParam(doctorId, beginTime, endTime,
					regId);
		return null;
	}

	public List<Order> findSawOrderListByParam(String doctorId,
			Timestamp beginTime, Timestamp endTime, String regId) {
		if (dao != null)
			return dao.findSawOrderListByParam(doctorId, beginTime, endTime,
					regId);
		return null;
	}

	public List<Order> findByOrderParam(String departmentId, Long patientId,
			Timestamp beginTime, Timestamp endTime, int status) {
		if (dao != null)
			return dao.findByOrderParam(departmentId, patientId, beginTime,
					endTime, status);
		return null;
	}

}
