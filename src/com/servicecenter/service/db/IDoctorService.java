package com.servicecenter.service.db;

import java.util.List;

import com.model.db.Doctor;
import com.servicecenter.IDAOBasedService;

public interface IDoctorService extends IDAOBasedService<Doctor, Integer> {

	public List<Doctor> findByDoctorCode(String doctorCode);

	public List<Doctor> findByName(String name);

	public List<Doctor> findByDeptCode(String deptCode);

}
