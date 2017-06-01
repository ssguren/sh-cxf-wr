package com.servicecenter.service.db;

import java.util.List;

import com.model.db.Department;
import com.servicecenter.IDAOBasedService;

public interface IDepartmentService extends
		IDAOBasedService<Department, Integer> {

	public List<Department> findAll();

	public List<Department> findById(String id);

	public Department findById(Integer id);
}
