package com.servicecenter.service.db;

import com.model.db.PatientCard;
import com.servicecenter.IDAOBasedService;

public interface IPatientCardService extends
		IDAOBasedService<PatientCard, Integer> {

	public PatientCard findByCardNum(String cardNum);

	public PatientCard findById(Integer id);

	public PatientCard findByPatientId(String patientId);
}
