package com.servicecenter;

import java.io.Serializable;
import java.util.List;

public interface IDAOBasedService<T extends Comparable<T>, A extends Serializable> {

	public boolean add(T instance);

	public boolean update(T instance);

	public boolean delete(T instance);

	public T merge(T instance);

	public boolean attachDirty(T instance);

	public boolean attachClean(T instance);

	public T findById(A id);

	public List<T> findAll();

	public List<T> findByPage(int pageNum);

	public Integer count();

	public void addBatch(List<T> list);

	public void updateBatch(List<T> list);
}