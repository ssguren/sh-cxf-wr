package com.datacenter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IPatientDAO;
import com.model.db.Patient;
import com.utils.StringUtil;

import edu.emory.mathcs.backport.java.util.Collections;

@Repository
public class PatientDAO extends BaseHibernateDAO<Patient> implements
		IPatientDAO {

	public static final String PATIENT_ID = "brid";
	public static final String PATIENT_NAME = "brxm";
	public static final String IDCODE = "sfzh";
	public static final String MEDICARE_CARD_NUM = "brkh";

	public Patient findById(Integer id) {
		return null;
	}

	public Patient findByBrid(Long id) {
		return findByProperty(PATIENT_ID, id).get(0);
	}

	public List<Patient> findByName(String name) {
		return findByProperty(PATIENT_NAME, name);
	}

	public Patient findByIdCode(String idCode) {
		return findByProperty(IDCODE, idCode).get(0);
	}

	public Patient findByInfo(String idCode, String name) {
		List<Patient> list = new ArrayList<Patient>();
		try {
			Criteria crit = getSession().createCriteria(Patient.class);
			if (!StringUtil.isEmptyStr(idCode) && !StringUtil.isEmptyStr(name)) {
				crit.add(Restrictions.eq(MEDICARE_CARD_NUM, idCode));
				crit.add(Restrictions.eq(PATIENT_NAME, name));
			}
			list = crit.list();
			if (list != null && list.size() > 0) {
				Collections.sort(list);
			}
		} catch (Exception e) {
			log.info(e);
		}
		return list.get(0);
	}

	public List<Patient> findByMediaCardNum(String mediaCardNum) {
		return findByProperty(MEDICARE_CARD_NUM, mediaCardNum);
	}

	public List<Patient> findByNameAndCardNum(String name, String mediaCardNum) {
		List<Patient> list = new ArrayList<Patient>();
		try {
			Criteria crit = getSession().createCriteria(Patient.class);
			if (!StringUtil.isEmptyStr(mediaCardNum)
					&& !StringUtil.isEmptyStr(name)) {
				crit.add(Restrictions.eq(MEDICARE_CARD_NUM, mediaCardNum));
				crit.add(Restrictions.eq(PATIENT_NAME, name));
			}
			list = crit.list();
			if (list != null && list.size() > 0) {
				Collections.sort(list);
			}
		} catch (Exception e) {
			log.info(e);
		}
		return list;
	}

	public Session getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}

}
