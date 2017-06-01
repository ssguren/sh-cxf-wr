package com.datacenter.dao.impl;

import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IPatientCardDAO;
import com.model.db.PatientCard;

@Repository
public class PatientCardDAO extends BaseHibernateDAO<PatientCard> implements
		IPatientCardDAO {
	public static final String CARD_NUM = "bxh";
	public static final String PATIENT_ID = "brid";


	public PatientCard findByCardNum(String cardNum) {
		return findByProperty(CARD_NUM, cardNum).get(0);
	}

	public PatientCard findByPatientId(String patientId) {
		return findByProperty(PATIENT_ID, Integer.parseInt(patientId)).get(0);
	}

	public PatientCard findById(Integer id) {
		try {
			PatientCard instance = (PatientCard) getSession().get(
					PatientCard.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
