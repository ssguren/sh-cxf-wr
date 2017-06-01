package com.datacenter.dao;

import java.util.List;

import com.datacenter.IBaseDAO;
import com.model.db.Department;

public interface IDepartmentDAO extends IBaseDAO<Department, Integer> {

	public List<Department> findAll();

	public List<Department> findById(String id);

	public Department findById(Integer id);
}
