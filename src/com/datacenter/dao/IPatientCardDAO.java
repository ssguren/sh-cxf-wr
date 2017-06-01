package com.datacenter.dao;

import com.datacenter.IBaseDAO;
import com.model.db.PatientCard;

public interface IPatientCardDAO extends IBaseDAO<PatientCard, Integer> {
	// 不清楚是否是存在一卡多用的情况
	public PatientCard findByCardNum(String cardNum);

	public PatientCard findByPatientId(String patientId);

	public PatientCard findById(Integer id);

}
