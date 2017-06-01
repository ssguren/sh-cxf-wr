package com.datacenter;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.datacenter.pager.PageCounter;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * Data access object (DAO) for domain model
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class BaseHibernateDAO<T extends Comparable<T>> extends
		HibernateTemplate {

	protected final Logger log = Logger.getLogger(getClass());

	protected PageCounter pageCounter = null;

	protected String classType;

	protected String hql_property;

	protected String hql_count;

	protected String hql_select;

	private static DataSource ds = null;

	public BaseHibernateDAO() {
		this.classType = ((Class<?>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0])
				.getSimpleName();
		this.hql_property = "from " + classType + " as model where model.";
		this.hql_count = "select count(*) from " + classType;
		this.hql_select = "from " + classType;
	}

	public boolean save(T instance) {
		try {
			super.save(instance);
			return true;
		} catch (DataAccessException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public boolean update(T instance) {
		try {
			super.update(instance);
			return true;
		} catch (DataAccessException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public boolean delete(T instance) {
		try {
			super.delete(instance);
			return true;
		} catch (DataAccessException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public T merge(T instance) {
		try {
			T result = (T) super.merge(instance);
			return result;
		} catch (DataAccessException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(T instance) {
		try {
			super.saveOrUpdate(instance);
			return true;
		} catch (DataAccessException re) {
			log.error("attachDirty failed", re);
			throw re;
		}
	}

	public boolean attachClean(T instance) {
		try {
			super.lock(instance, LockMode.NONE);

			return true;
		} catch (DataAccessException re) {
			log.error("attachClean failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		try {
			String queryString = hql_property + propertyName + "= ?";
			List<T> res = (List<T>) getCacheHibernateTemplate().find(
					queryString, value);

			if (res != null)
				Collections.sort(res);

			return res;
		} catch (DataAccessException re) {
			log.error("find by property failed: " + propertyName + "=" + value);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByPropertyNonCache(String propertyName, Object value) {
		try {
			String queryString = hql_property + propertyName + "= ?";
			List<T> res = (List<T>) getNonCacheHibernateTemplate().find(
					queryString, value);

			if (res != null)
				Collections.sort(res);

			return res;
		} catch (DataAccessException re) {
			log.error("find by property failed: " + propertyName + "=" + value);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		try {
			List<T> res = (List<T>) getCacheHibernateTemplate()
					.find(hql_select);

			if (res != null)
				Collections.sort(res);

			return res;
		} catch (DataAccessException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Integer count() {
		Query query = getSession().createQuery(hql_count);
		return ((Long) query.uniqueResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByPage(int pageNum) {
		if (null == this.pageCounter) {
			this.pageCounter = new PageCounter(this.count());
		} else {
			this.pageCounter.refresh(this.count());
		}
		this.pageCounter.pageTo(pageNum);
		Query query = getSession().createQuery(hql_select);
		query.setFirstResult(this.pageCounter.getCurrentItem());
		query.setMaxResults(this.pageCounter.getPageSize());

		return query.list();
	}

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	protected HibernateTemplate getCacheHibernateTemplate() {
		this.setCacheQueries(true);
		return this;
	}

	protected HibernateTemplate getNonCacheHibernateTemplate() {
		this.setCacheQueries(false);
		return this;
	}

	public final Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	protected final Connection getConnection() {
		if (ds == null)
			ds = (DataSource) SessionFactoryUtils
					.getDataSource(getSessionFactory());

		return ds == null ? null : DataSourceUtils.getConnection(ds);
	}

	protected final void releaseConnection(Connection conn) {
		if (conn != null && ds != null) {
			DataSourceUtils.releaseConnection(conn, ds);
		}
	}
}