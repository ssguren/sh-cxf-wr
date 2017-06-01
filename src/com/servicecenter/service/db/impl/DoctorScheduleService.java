package com.servicecenter.service.db.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.impl.DoctorScheduleDAO;
import com.model.db.DoctorSchedule;
import com.model.db.DoctorScheduleId;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IDoctorScheduleService;

@Service
@Transactional(readOnly = true)
public class DoctorScheduleService extends
		DAOBasedService<DoctorSchedule, Integer, DoctorScheduleDAO> implements
		IDoctorScheduleService {

	public DoctorSchedule findByDoctorId(DoctorScheduleId id) {
		if (dao != null)
			return dao.findByDoctorId(id);
		return null;
	}

	public List<DoctorSchedule> findByDate(Timestamp beginDate,
			Timestamp endDate) {
		List<DoctorSchedule> tempList = new ArrayList<DoctorSchedule>();
		if (dao != null) {
			List<DoctorSchedule> dsList = dao.findByDate(beginDate, endDate);
			for (DoctorSchedule info : dsList) {
				if (info.getId().getGzrq().toString().substring(0, 11).equals(
						info.getKssj().toString().substring(0, 11))
						&& info.getId().getGzrq().toString().substring(0, 11)
								.equals(
										info.getJssj().toString().substring(0,
												11))) {
					tempList.add(info);
				}
			}
		}
		return tempList;
	}

	public List<DoctorSchedule> findByOrderTime(String doctorId,
			Timestamp orderTime) {
		if (dao != null)
			return dao.findByOrderTime(doctorId, orderTime);
		return null;
	}

	public List<DoctorSchedule> findByDoctorCode(String doctorId) {
		if (dao != null)
			return dao.findByDoctorCode(doctorId);
		return null;
	}

}
