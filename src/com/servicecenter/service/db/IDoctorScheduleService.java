package com.servicecenter.service.db;

import java.sql.Timestamp;
import java.util.List;

import com.model.db.DoctorSchedule;
import com.model.db.DoctorScheduleId;
import com.servicecenter.IDAOBasedService;

public interface IDoctorScheduleService extends
		IDAOBasedService<DoctorSchedule, Integer> {
	public DoctorSchedule findByDoctorId(DoctorScheduleId id);

	public List<DoctorSchedule> findByDate(Timestamp beginDate,
			Timestamp endDate);

	public List<DoctorSchedule> findByOrderTime(String doctorId,
			Timestamp orderTime);

	public List<DoctorSchedule> findByDoctorCode(String doctorId);
}
