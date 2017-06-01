package com.servicecenter.service.db;

import java.sql.Timestamp;
import java.util.List;

import com.model.db.Order;
import com.servicecenter.IDAOBasedService;

public interface IOrderService extends IDAOBasedService<Order, Integer> {
	public Order findById(Integer id);

	public List<Order> findByPatientId(String patientId);

	public List<Order> findByDoctorAndTime(String doctorId,
			Timestamp beginTime, Timestamp endTime);

	public List<Order> findByDoctorAndTime(String doctorId, String beginTime,
			String endTime);

	public List<Order> findByOrderParam(String doctorId, Timestamp beginTime,
			Timestamp endTime, String regId);

	public String findOrderNumByOrder(Order order);

	public List<String> findAllDepartment();

	public List<Order> findByOrderParam(String departmentId, Long patientId,
			Timestamp beginTime, Timestamp endTime, int status);

	// 手机候诊
	public List<Order> findWaitingListByParam(String doctorId,
			Timestamp beginTime, Timestamp endTime, String regId);

	public List<Order> findSawOrderListByParam(String doctorId,
			Timestamp beginTime, Timestamp endTime, String regId);
}
