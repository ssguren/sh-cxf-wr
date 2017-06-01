package com.servicecenter.service.db.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.IDoctorDAO;
import com.model.db.Doctor;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IDoctorService;

@Service
@Transactional(readOnly = true)
public class DoctorService extends DAOBasedService<Doctor, Integer, IDoctorDAO>
		implements IDoctorService {

	public List<Doctor> findByDeptCode(String deptCode) {
		if (dao != null) {
			return dao.findByDeptCode(deptCode);
		}
		return null;
	}

	public List<Doctor> findByDoctorCode(String doctorCode) {
		if (dao != null)
			return dao.findByDoctorCode(doctorCode);
		return null;
	}

	public List<Doctor> findByName(String name) {
		if (dao != null)
			return dao.findByName(name);
		return null;
	}

	@Override
	public Doctor findById(Integer id) {
		if (dao != null)
			return dao.findById(id);
		return null;
	}

}
