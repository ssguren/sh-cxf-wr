package com.datacenter.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IDoctorDAO;
import com.model.db.Doctor;

@Repository
public class DoctorDAO extends BaseHibernateDAO<Doctor> implements IDoctorDAO {

	// property constants
	public static final String ID = "id";
	public static final String DOCTOR_ID = "ysdm";
	public static final String DEPARTMENT_ID = "ksdm";
	public static final String DOCTOR_NAME = "ygxm";


	public List<Doctor> findByDeptCode(String deptCode) {
		return findByProperty(DEPARTMENT_ID, deptCode);
	}

	public List<Doctor> findByDoctorCode(String doctorCode) {
		return findByProperty(DOCTOR_ID, doctorCode);
	}

	public List<Doctor> findByName(String name) {
		return findByProperty(DOCTOR_NAME, name);
	}

	public Doctor findById(Integer id) {
		return findByProperty(ID, id).get(0);
	}
}
