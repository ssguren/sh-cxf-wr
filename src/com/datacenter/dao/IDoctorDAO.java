package com.datacenter.dao;

import java.util.List;

import com.datacenter.IBaseDAO;
import com.model.db.Doctor;

public interface IDoctorDAO extends IBaseDAO<Doctor, Integer> {

	public List<Doctor> findByDoctorCode(String doctorCode);

	public List<Doctor> findByName(String name);

	public List<Doctor> findByDeptCode(String deptCode);

}
