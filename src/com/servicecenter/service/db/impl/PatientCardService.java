package com.servicecenter.service.db.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.IPatientCardDAO;
import com.model.db.PatientCard;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IPatientCardService;

@Service
@Transactional(readOnly = true)
public class PatientCardService extends
		DAOBasedService<PatientCard, Integer, IPatientCardDAO> implements
		IPatientCardService {

	public PatientCard findByCardNum(String cardNum) {
		if (dao != null)
			return dao.findByCardNum(cardNum);
		return null;
	}

	public PatientCard findByPatientId(String patientId) {
		if (dao != null)
			return dao.findByPatientId(patientId);
		return null;
	}

	@Override
	public PatientCard findById(Integer id) {
		if (dao != null)
			return dao.findById(id);
		return null;
	}

}
