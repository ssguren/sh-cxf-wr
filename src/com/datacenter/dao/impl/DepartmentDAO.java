package com.datacenter.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IDepartmentDAO;
import com.model.db.Department;

@Repository
public class DepartmentDAO extends BaseHibernateDAO<Department> implements
		IDepartmentDAO {

	public static final String DEPTARTMENT_ID = "ksdm";
	public static final String DEPTARTMENT_CODE = "mzks";


	public Department findById(Integer id) {
		return findByProperty(DEPTARTMENT_ID, id.toString()).get(0);
	}

	public List<Department> findById(String id) {
		return findByProperty(DEPTARTMENT_ID, id);
	}

}
