package com.model.ws.rs;

import com.model.ws.DepartmentInfo;
import com.model.ws.WSResult;

public class DepartmentResult extends WSResult {
	private DepartmentInfo departmentInfo;

	public DepartmentResult() {
		super();
	}

	public DepartmentInfo getDepartment() {
		return departmentInfo;
	}

	public void setDepartment(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

}
