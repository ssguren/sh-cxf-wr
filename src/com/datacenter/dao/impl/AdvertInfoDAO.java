package com.datacenter.dao.impl;

// default package

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IAdvertInfoDAO;
import com.model.db.AdvertInfo;
import com.utils.StringUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdverInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .AdverInfo
 * @author MyEclipse Persistence Tools
 */
@Repository
public class AdvertInfoDAO extends BaseHibernateDAO<AdvertInfo> implements
		IAdvertInfoDAO {
	// property constants
	public static final String ADVERT_NAME = "advertName";
	public static final String PLAY_TIME = "playTime";
	public static final String REL_URL = "relUrl";
	public static final String ID = "id";
	public static final String IS_EFFECTIVE = "isEffective";
	public static final String UP_SHELF_TIME = "upShelfTime";
	public static final String DOWN_SHELF_TIME = "downShelfTime";
	public static final String CREATE_TIME = "createTime";

	public AdvertInfo findById(java.lang.Integer id) {
		log.debug("getting AdverInfo instance with id: " + id);
		try {
			AdvertInfo instance = (AdvertInfo) getCacheHibernateTemplate().get(
					AdvertInfo.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public AdvertInfo findByIdAndTime(java.lang.Integer id, Date date) {
		Criteria crit = super.getSession().createCriteria(AdvertInfo.class);
		crit.add(Restrictions.eq(ID, id));
		crit.add(Restrictions.ge(DOWN_SHELF_TIME, date));
		crit.add(Restrictions.le(UP_SHELF_TIME, date));
		crit.add(Restrictions.eq(IS_EFFECTIVE, (short) 0));
		List<AdvertInfo> list = crit.list();
		if (null != list && list.size() > 0) {
			Collections.sort(list);
			return list.get(0);
		}
		return null;
	}

	public List<AdvertInfo> findByName(String advertName) {
		return findByProperty(ADVERT_NAME, advertName);
	}

	public List<AdvertInfo> findByPlayTime(Integer playTime) {
		return findByProperty(PLAY_TIME, playTime);
	}

	public List<AdvertInfo> findByRelUrl(String relUrl) {
		return findByProperty(REL_URL, relUrl);
	}

	public List<AdvertInfo> findByIsEffective(Short isEffective) {
		return findByProperty(IS_EFFECTIVE, isEffective);
	}

	@SuppressWarnings("unchecked")
	// @Override
	public List<AdvertInfo> findByIdLikeNameAndTimeProperties(Integer id,
			String likeName, Date beginTime, Date endTime, Short status) {
		Criteria crit = super.getSession().createCriteria(AdvertInfo.class);
		if (null != id)
			crit.add(Restrictions.eq(ID, id));
		if (!StringUtil.isEmptyStr(likeName))
			crit.add(Restrictions.like(ADVERT_NAME, likeName,
					MatchMode.ANYWHERE));
		if (null != beginTime)
			crit.add(Restrictions.ge(CREATE_TIME, beginTime));
		if (null != endTime)
			crit.add(Restrictions.le(CREATE_TIME, endTime));
		if (null != status)
			crit.add(Restrictions.eq(IS_EFFECTIVE, status));

		List<AdvertInfo> list = crit.list();
		if (null != list && list.size() > 0) {
			Collections.sort(list);
		}
		return list;
	}
}