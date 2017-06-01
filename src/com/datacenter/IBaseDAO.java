package com.datacenter;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface IBaseDAO<T extends Comparable<T>, A extends Serializable> {

	public boolean save(T instance);

	public boolean update(T instance);

	public boolean delete(T instance);

	public T merge(T instance);

	public boolean attachDirty(T instance);

	public boolean attachClean(T instance);

	public T findById(A id);

	public List<T> findByProperty(String propertyName, Object value);

	public List<T> findAll();

	public Integer count();

	public List<T> findByPage(int pageNum);

	public Session getSession();
}
