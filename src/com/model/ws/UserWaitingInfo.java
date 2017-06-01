package com.model.ws;

public class UserWaitingInfo {
	private String currentSeq;// 当前就诊序号
	private String orderSeq;// 用户所排序号
	private String waitNum;// 等待人数
	private String estimateTime;// 预计就诊时间
	private String depName;
	private String docName;
	private String waitList;

	public String getCurrentSeq() {
		return currentSeq;
	}

	public void setCurrentSeq(String currentSeq) {
		this.currentSeq = currentSeq;
	}

	public String getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(String orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getWaitNum() {
		return waitNum;
	}

	public void setWaitNum(String waitNum) {
		this.waitNum = waitNum;
	}

	public String getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(String estimateTime) {
		this.estimateTime = estimateTime;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getWaitList() {
		return waitList;
	}

	public void setWaitList(String waitList) {
		this.waitList = waitList;
	}

	@Override
	public String toString() {
		return "UserWaitingInfo [currentSeq=" + currentSeq + ", depName="
				+ depName + ", docName=" + docName + ", estimateTime="
				+ estimateTime + ", orderSeq=" + orderSeq + ", waitList="
				+ waitList + ", waitNum=" + waitNum + "]";
	}

}
