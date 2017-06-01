package com.datacenter.dao;

import java.util.List;

import com.datacenter.IBaseDAO;
import com.model.db.Patient;


public interface IPatientDAO extends IBaseDAO<Patient, Integer> {
	
	public Patient findByBrid(Long id);
	
	public List<Patient> findByName(String name);
	
	public Patient findByIdCode(String idCode);
	
	public Patient findByInfo(String idCode,String name);
	
	public List<Patient> findByMediaCardNum(String mediaCardNum);
	
	public List<Patient> findByNameAndCardNum(String name,String mediaCardNum);

}
