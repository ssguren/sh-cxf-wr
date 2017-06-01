package com.model.ws.rs;

import java.util.List;

import com.model.ws.ScheduleInfo;
import com.model.ws.WSResult;

public class ScheduleResult extends WSResult {
	private List<ScheduleInfo> scheduleList;

	public List<ScheduleInfo> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<ScheduleInfo> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public ScheduleResult() {
		super();
	}

}
