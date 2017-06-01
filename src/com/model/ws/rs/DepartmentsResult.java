package com.model.ws.rs;

import java.util.List;

import com.model.ws.DepartmentInfo;
import com.model.ws.WSResult;

public class DepartmentsResult extends WSResult {

	private List<DepartmentInfo> departmentList;

	public List<DepartmentInfo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentInfo> departmentList) {
		this.departmentList = departmentList;
	}

	public DepartmentsResult() {
		super();
	}

}
