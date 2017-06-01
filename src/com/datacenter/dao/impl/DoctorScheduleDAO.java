package com.datacenter.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IDoctorScheduleDAO;
import com.model.db.DoctorSchedule;
import com.model.db.DoctorScheduleId;

@Repository
public class DoctorScheduleDAO extends BaseHibernateDAO<DoctorSchedule>
		implements IDoctorScheduleDAO {

	public static final String START_TIME = "kssj";
	public static final String END_TIME = "jssj";
	public static final String DOCTOR_ID = "id.ysdm";
	public static final String DUTY_TYPE = "zblb";
	public static final String CHANNEL = "pb114";


	public DoctorSchedule findByDoctorId(DoctorScheduleId id) {
		try {
			DoctorSchedule instance = (DoctorSchedule) getCacheHibernateTemplate()
					.get(DoctorSchedule.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DoctorSchedule> findByDoctorCode(String doctorId) {
		return findByProperty(DOCTOR_ID, doctorId);
	}

	public DoctorSchedule findById(Integer id) {
		return null;
	}

	public List<DoctorSchedule> findByDate(Timestamp beginDate,
			Timestamp endDate) {
		List<DoctorSchedule> list = new ArrayList<DoctorSchedule>();
		try {
			Criteria crit = getSession().createCriteria(DoctorSchedule.class);
			if (null != beginDate && null != endDate) {
				crit.add(Restrictions.between(START_TIME, beginDate, endDate));
			}
			crit.add(Restrictions.eq(CHANNEL, 1));
			list = crit.list();
			if (list != null) {
				Collections.sort(list);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<DoctorSchedule> findByOrderTime(String doctorId,
			Timestamp orderTime) {
		List<DoctorSchedule> list = new ArrayList<DoctorSchedule>();
		try {
			Criteria crit = getSession().createCriteria(DoctorSchedule.class);
			if (null != orderTime) {
				crit.add(Restrictions.lt(END_TIME, orderTime));
				crit.add(Restrictions.gt(START_TIME, orderTime));
			}
			if (null != doctorId) {
				crit.add(Restrictions.eq(DOCTOR_ID, doctorId));
			}
			crit.add(Restrictions.eq(CHANNEL, 1));
			list = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
