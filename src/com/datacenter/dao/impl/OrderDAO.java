package com.datacenter.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IOrderDAO;
import com.model.db.Order;
import com.utils.StringUtil;

import edu.emory.mathcs.backport.java.util.Collections;

@Repository
public class OrderDAO extends BaseHibernateDAO<Order> implements IOrderDAO {

	public static final String ID = "yyxh";
	public static final String PATIENT_ID = "brid";
	public static final String DEPARTMENT_ID = "ksdm";
	public static final String DOCTOR_ID = "ysdm";
	public static final String ORDER_TYPE = "yylb";
	public static final String DUTY_TYPE = "zblb";
	public static final String ORDER_TIME = "yyrq";
	public static final String REG_ID = "yybh";
	public static final String ORDER_CONFIRM = "zfpb";
	public static final String EXPERT_TYPE = "zjbz";
	public static final String CONFIRM_TYPE = "qrbz";
	public static final String PATIENT_PHONE = "lxdh";


	public Order findById(Integer id) {
		return findByProperty(ID, Long.parseLong(Integer.toString(id))).get(0);
	}

	public List<Order> findByPatientId(String patientId) {
		return findByProperty(PATIENT_ID, Long.parseLong(patientId));
	}

	public List<Order> findByDoctorAndTime(String doctorId,
			Timestamp beginTime, Timestamp endTime) {
		List<Order> list = new ArrayList<Order>();
		try {
			Criteria crit = getSession().createCriteria(Order.class);
			if (null != doctorId && null != beginTime && null != endTime) {
				crit.add(Restrictions.eq(DOCTOR_ID, doctorId));
				crit.add(Restrictions.between(ORDER_TIME, beginTime, endTime));
			}
			crit.add(Restrictions.eq(ORDER_CONFIRM, 0));
			list = crit.list();
			if (list != null && list.size() > 0) {
				Collections.sort(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Order> findByOrderParam(String doctorId, Timestamp beginTime,
			Timestamp endTime, String regId) {
		List<Order> list = new ArrayList<Order>();
		try {
			Criteria crit = getSession().createCriteria(Order.class);
			if (null != doctorId && null != beginTime && null != endTime) {
				crit.add(Restrictions.eq(DOCTOR_ID, doctorId));
				crit.add(Restrictions.between(ORDER_TIME, beginTime, endTime));
			}
			if (!StringUtil.isEmptyStr(regId)) {
				crit.add(Restrictions.eq(REG_ID, Short.parseShort(regId)));
			}
			crit.add(Restrictions.eq(ORDER_CONFIRM, 0));
			list = crit.list();
			if (list != null && list.size() > 0) {
				Collections.sort(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Order> findWaitingListByParam(String doctorId,
			Timestamp beginTime, Timestamp endTime, String regId) {
		List<Order> list = new ArrayList<Order>();
		try {
			Criteria crit = getSession().createCriteria(Order.class);
			if (null != doctorId && null != beginTime && null != endTime) {
				crit.add(Restrictions.eq(DOCTOR_ID, doctorId));
				crit.add(Restrictions.between(ORDER_TIME, beginTime, endTime));
			}
			if (!StringUtil.isEmptyStr(regId)) {
				crit.add(Restrictions.lt(REG_ID, Short.parseShort(regId)));
			}
			crit.add(Restrictions.eq(ORDER_CONFIRM, 0));
			list = crit.list();
			if (list != null && list.size() > 0) {
				Collections.sort(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String findOrderNumByOrder(Order order) {
		List<Order> list = new ArrayList<Order>();
		try {
			Criteria crit = getSession().createCriteria(Order.class);
			if (order != null) {
				if (order.getBrid() != null)
					crit.add(Restrictions.eq(PATIENT_ID, order.getBrid()));
				if (order.getKsdm() != null)
					crit.add(Restrictions.eq(DEPARTMENT_ID, order.getKsdm()));
				if (order.getYsdm() != null)
					crit.add(Restrictions.eq(DOCTOR_ID, order.getYsdm()));
				if (order.getYylb() != null)
					crit.add(Restrictions.eq(ORDER_TYPE, order.getYylb()));
				if (order.getZblb() != null)
					crit.add(Restrictions.eq(DUTY_TYPE, order.getZblb()));
				if (order.getYyrq() != null)
					crit.add(Restrictions.eq(ORDER_TIME, order.getYyrq()));
				if (order.getYybh() != null)
					crit.add(Restrictions.eq(REG_ID, order.getYybh()));
				if (order.getZfpb() != null)
					crit.add(Restrictions.eq(ORDER_CONFIRM, order.getZfpb()));
				if (order.getZjbz() != null)
					crit.add(Restrictions.eq(EXPERT_TYPE, order.getZjbz()));
				if (order.getLxdh() != null)
					crit.add(Restrictions.eq(PATIENT_PHONE, order.getLxdh()));
				list = crit.list();
				if (list != null && list.size() > 0) {
					Collections.sort(list);
					String orderNum = list.get(0).getYyxh().toString();
					return orderNum;
				}
			}
		} catch (Exception e) {
			log.info(e);
		}
		return null;
	}

	public List<Order> findSawOrderListByParam(String doctorId,
			Timestamp beginTime, Timestamp endTime, String regId) {
		List<Order> list = new ArrayList<Order>();
		try {
			Criteria crit = getSession().createCriteria(Order.class);
			if (null != doctorId && null != beginTime && null != endTime) {
				crit.add(Restrictions.eq(DOCTOR_ID, doctorId));
				crit.add(Restrictions.between(ORDER_TIME, beginTime, endTime));
			}
			if (!StringUtil.isEmptyStr(regId)) {
				crit.add(Restrictions.lt(REG_ID, Short.parseShort(regId)));
			}
			crit.add(Restrictions.eq(ORDER_CONFIRM, 1));
			list = crit.list();
			if (list != null && list.size() > 0) {
				Collections.sort(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> findAllDepartment() {
		List<String> list = new ArrayList<String>();
		try {
			String hql = "select distinct ksdm from Order ";
			list = getSession().createQuery(hql).list();
			// Connection conn = BaseHibernateDAO.getConnection();
			// Statement stat = conn.createStatement();
			// ResultSet rs = null;
			// rs = stat.executeQuery(hql);
			// if (null != rs) {
			// while (rs.next()) {
			// list.add(rs.getString(0));
			// }
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Order> findByOrderParam(String departmentId, Long patientId,
			Timestamp beginTime, Timestamp endTime, int status) {
		List<Order> list = new ArrayList<Order>();
		try {
			Criteria crit = getSession().createCriteria(Order.class);
			if (!StringUtil.isEmptyStr(departmentId)) {
				crit.add(Restrictions.eq(DEPARTMENT_ID, departmentId));
			}
			if (null != patientId && null != beginTime && null != endTime) {
				crit.add(Restrictions.eq(PATIENT_ID, patientId));
				crit.add(Restrictions.between(ORDER_TIME, beginTime, endTime));
			}
			crit.add(Restrictions.eq(ORDER_CONFIRM, status));
			list = crit.list();
			if (list != null && list.size() > 0) {
				Collections.sort(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
