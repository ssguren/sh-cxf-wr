package com.servicecenter;

import java.io.Serializable;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.IBaseDAO;

public abstract class DAOBasedService<T extends Comparable<T>, A extends Serializable, D extends IBaseDAO<T, A>>
		extends BaseService implements IDAOBasedService<T, A> {

	protected D dao;

	@Autowired
	public void setDao(D dao) {
		this.dao = dao;
	}

	@Override
	public void postConstruct() {
		if (this.dao != null)
			log.info(getClass() + " is inited!");
		else
			log.error(getClass() + " is NOT init!");
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean add(T instance) {
		if (dao != null)
			return dao.save(instance);

		return false;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean update(T instance) {
		if (dao != null)
			return dao.update(instance);

		return false;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean delete(T instance) {
		if (dao != null)
			return dao.delete(instance);

		return false;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public T merge(T instance) {
		if (dao != null)
			return dao.merge(instance);

		return null;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean attachDirty(T instance) {
		if (dao != null)
			return dao.attachDirty(instance);

		return false;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean attachClean(T instance) {
		if (dao != null)
			return dao.attachClean(instance);

		return false;
	}

	@Transactional(readOnly = true)
	public T findById(A id) {
		if (dao != null)
			return dao.findById(id);

		return null;
	}

	@Transactional(readOnly = true)
	public List<T> findAll() {
		if (dao != null)
			return dao.findAll();

		return null;
	}

	@Transactional(readOnly = true)
	public List<T> findByPage(int pageNum) {
		if (null != dao)
			return this.dao.findByPage(pageNum);

		return null;
	}

	@Transactional(readOnly = true)
	public Integer count() {
		if (null != dao)
			return this.dao.count();

		return 0;
	}

	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public void addBatch(List<T> list) {
		if (dao != null && list != null) {
			Session session = dao.getSession();
			session.setFlushMode(FlushMode.MANUAL);
			session.setCacheMode(CacheMode.IGNORE);
			Transaction tx = session.beginTransaction();
			int count = 0;
			for (T t : list) {
				session.save(t);
				count++;
				if (count % 100 == 0) {
					session.flush();
				}
			}

			session.flush();
			tx.commit();
			session.close();
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public void updateBatch(List<T> list) {
		if (dao != null && list != null) {
			Session session = dao.getSession();
			session.setFlushMode(FlushMode.MANUAL);
			session.setCacheMode(CacheMode.IGNORE);
			Transaction tx = session.beginTransaction();
			int count = 0;
			for (T t : list) {
				session.update(t);
				count++;
				if (count % 100 == 0) {
					session.flush();
				}
			}

			session.flush();
			tx.commit();
			session.close();
		}
	}
}
