package com.model.ws.rs;

import java.util.List;

import com.model.ws.DoctorInfo;
import com.model.ws.WSResult;

public class DoctorsResult extends WSResult {

	private List<DoctorInfo> doctorList;

	public List<DoctorInfo> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<DoctorInfo> doctorList) {
		this.doctorList = doctorList;
	}

	public DoctorsResult() {
		super();
	}

}
