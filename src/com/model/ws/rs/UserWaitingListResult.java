package com.model.ws.rs;

import com.model.ws.UserWaitingInfo;
import com.model.ws.WSResult;

public class UserWaitingListResult extends WSResult {

	private UserWaitingInfo userWaitingInfo;

	public UserWaitingInfo getUserWaitingInfo() {
		return userWaitingInfo;
	}

	public void setUserWaitingInfo(UserWaitingInfo userWaitingInfo) {
		this.userWaitingInfo = userWaitingInfo;
	}

}
