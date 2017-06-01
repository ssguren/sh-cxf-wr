package com.model.ws.rs;

import com.model.ws.DoctorInfo;
import com.model.ws.WSResult;

public class DoctorResult extends WSResult {

	private DoctorInfo doctorInfo;

	public DoctorInfo getDoctor() {
		return doctorInfo;
	}

	public void setDoctor(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}

	public DoctorResult() {
		super();
	}

}
