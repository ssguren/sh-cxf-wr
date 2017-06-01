package com.model.ws;

public class ScheduleInfo implements Cloneable {

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	private String availableNum;
	private String consultationFee;
	private String dayOfWeek;
	private String doctorId;
	private String isSuspend;
	private String outcallDate;
	private String regId;
	private String schId;
	private String timeRange;

	public String getAvailableNum() {
		return availableNum;
	}

	public void setAvailableNum(String availableNum) {
		this.availableNum = availableNum;
	}

	public String getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(String consultationFee) {
		this.consultationFee = consultationFee;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getIsSuspend() {
		return isSuspend;
	}

	public void setIsSuspend(String isSuspend) {
		this.isSuspend = isSuspend;
	}

	public String getOutcallDate() {
		return outcallDate;
	}

	public void setOutcallDate(String outcallDate) {
		this.outcallDate = outcallDate;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getSchId() {
		return schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}

}
