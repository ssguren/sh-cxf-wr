package com.servicecenter.service.db.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.IPatientDAO;
import com.model.db.Patient;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IPatientService;

@Service
@Transactional(readOnly = true)
public class PatientService extends
		DAOBasedService<Patient, Integer, IPatientDAO> implements
		IPatientService {

	public Patient findByBrid(Long id) {
		if (dao != null)
			return dao.findByBrid(id);
		return null;
	}

	public List<Patient> findByName(String name) {
		if (dao != null)
			return dao.findByName(name);
		return null;
	}

	public Patient findByIdCode(String idCode) {
		if (dao != null)
			return dao.findByIdCode(idCode);
		return null;
	}

	public Patient findByInfo(String idCode, String name) {
		if (dao != null)
			return dao.findByInfo(idCode, name);
		return null;
	}

	public List<Patient> findByMediaCardNum(String mediaCardNum) {
		if (dao != null)
			return dao.findByMediaCardNum(mediaCardNum);
		return null;
	}

	public List<Patient> findByNameAndCardNum(String name, String mediaCardNum) {
		if (dao != null)
			return dao.findByNameAndCardNum(name, mediaCardNum);
		return null;
	}

}
