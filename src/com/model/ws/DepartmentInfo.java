package com.model.ws;

public class DepartmentInfo {

	private String clinicScope;
	private String departmentId;// ksdm
	private String departmentName;
	private String intro;
	private String deptId;// mzks

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getClinicScope() {
		return clinicScope;
	}

	public void setClinicScope(String clinicScope) {
		this.clinicScope = clinicScope;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
