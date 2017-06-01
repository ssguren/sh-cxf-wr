package com.servicecenter.service.db;

import java.util.List;

import com.model.db.Patient;
import com.servicecenter.IDAOBasedService;

public interface IPatientService extends IDAOBasedService<Patient, Integer> {

	public Patient findByBrid(Long id);

	public List<Patient> findByName(String name);

	public Patient findByIdCode(String idCode);

	public Patient findByInfo(String idCode, String name);

	public List<Patient> findByMediaCardNum(String mediaCardNum);

	public List<Patient> findByNameAndCardNum(String name, String mediaCardNum);
}
