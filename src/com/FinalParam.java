package com;

public class FinalParam {

	public static final int MIDDLE_DAY = 13;

	public static final String INSURANCE_CARD = "SB";// 社保医保
	public static final String MEDICARE_CARD = "MC";// 诊疗卡

	public static final byte REG_CHANNEL_LOCAL = 1;// 现场预约渠道
	public static final byte REG_CHANNEL_TEL = 2;// 电话
	public static final byte REG_CHANNEL_WEB = 3;// 网上
	public static final byte REG_CHANNEL_SMS = 4;// 短信
	public static final byte REG_CHANNEL_SERVERBAR = 5;// 服务台

	public static final int ORDER_STATUS_VALID = 0;// 作废标识
	public static final int ORDER_STATUS_UNVALID = 1;

	public static final int REGIST_UNCONFIRM = 0;// 确认标识
	public static final int REGIST_CONFIRM = 1;

	public static final int REGIST_FEE = 1;// 挂号费
	public static final int CONSULTATION_FEE_EXP = 9;// 专家诊金
	public static final int CONSULTATION_FEE_UNEXP = 3;// 非专家诊金

	public static final Integer EXPERT_TYPE_UNEXP = 0;// 非专家标识
	public static final Integer EXPERT_TYPE_EXP = 1;

	public static final Short DUTY_TYPE_MORNING = 1;// 值班类别
	public static final Short DUTY_TYPE_AFTERNOON = 2;

	public static final String ORDER_TYPE = "6";// 114

	public static final String WORK_BEGIN_TIME = " 00:00:00";
	public static final String WORK_END_TIME = " 23:00:00";

	public static final String DUTY_BEGIN_MORNING = " 08:00:00";
	public static final String DUTY_BEGIN_AFTERNOON = " 14:30:00";

	public static final String DUTY_TIME_MORNING = "08:00-12:00";
	public static final String DUTY_TIME_AFTERNOON = "14:30-17:30";

	public static final String WSRESULT_CODE_SUCCESS = "0000";
	public static final String WSRESULT_CODE_FAIL = "0001";
	public static final String WSRESULT_CODE_PARAM_ERROR = "0002";
	public static final String WSRESULT_CODE_SCHEDULE_ERROR = "0003";
	public static final String WSRESULT_CODE_PATIENT_ERROR = "0004";
	public static final String WSRESULT_CODE_OTHER_ERROR = "0005";

}
