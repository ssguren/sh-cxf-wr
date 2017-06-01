package com.datacenter.dao;

import java.sql.Timestamp;
import java.util.List;

import com.datacenter.IBaseDAO;
import com.model.db.DoctorSchedule;
import com.model.db.DoctorScheduleId;

public interface IDoctorScheduleDAO extends IBaseDAO<DoctorSchedule, Integer> {
	public DoctorSchedule findByDoctorId(DoctorScheduleId doctorScheduleId);

	public List<DoctorSchedule> findByDate(Timestamp beginDate,
			Timestamp endDate);

	public List<DoctorSchedule> findByOrderTime(String doctorId,
			Timestamp orderTime);

	public List<DoctorSchedule> findByDoctorCode(String doctorId);

}
