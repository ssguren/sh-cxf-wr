package com.servicecenter.service.db.impl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.IDepartmentDAO;
import com.model.db.Department;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IDepartmentService;

@Service
@Transactional(readOnly = true)
public class DeparmentService extends
		DAOBasedService<Department, Integer, IDepartmentDAO> implements
		IDepartmentService {

	@Override
	public List<Department> findAll() {
		if (dao != null)
			return dao.findAll();
		return null;
	}

	public List<Department> findById(String id) {
		if (dao != null)
			return dao.findById(id);
		return null;
	}

	@Override
	public Department findById(Integer id) {
		if (dao != null)
			return dao.findById(id);
		return null;
	}

	public ResultSet query(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
