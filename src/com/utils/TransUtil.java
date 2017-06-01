package com.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.FinalParam;
import com.model.db.Department;
import com.model.db.Doctor;
import com.model.db.DoctorSchedule;
import com.model.ws.DepartmentInfo;
import com.model.ws.DoctorInfo;
import com.model.ws.ScheduleInfo;

public class TransUtil {

	public static String getTimeRange(String tempBeginTime, int index,
			long spaceTime) {
		try {
			Long startMS = DateUtil.parseDateSecondFormat(tempBeginTime)
					.getTime() + (index - 1) * spaceTime;
			Long endMS = startMS + spaceTime;
			String startTimeRange = DateUtil.getDateSecondFormat(
					new Date(startMS)).substring(11, 16);
			String endTimeRange = DateUtil.getDateSecondFormat(new Date(endMS))
					.substring(11, 16);
			String timeRange = startTimeRange + "-" + endTimeRange;
			return timeRange;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Long getMilliSecond(String tempBeginTime, String tempEndTime,
			int count) {
		try {
			long ms = (DateUtil.parseDateSecondFormat(tempEndTime).getTime() - DateUtil
					.parseDateSecondFormat(tempBeginTime).getTime()) / count;

			return ms;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<ScheduleInfo> changeSchedule(List<DoctorSchedule> list,
			String departmentId) {
		List<ScheduleInfo> infoList = new ArrayList<ScheduleInfo>();
		if (null != list && list.size() > 0) {
			for (DoctorSchedule ds : list) {
				if (!StringUtil.isEmptyStr(departmentId)
						&& departmentId.equals(ds.getId().getKsdm())) {
					ScheduleInfo info = changeDtSche2ScheInfo(ds);
					infoList.add(info);
				}
			}
		}
		return infoList;
	}

	public static ScheduleInfo changeDtSche2ScheInfo(DoctorSchedule ds) {
		ScheduleInfo info = new ScheduleInfo();
		info.setDoctorId(ds.getId().getYsdm());
		info.setDayOfWeek(Short.toString(ds.getWeek()));
		info.setAvailableNum(Short.toString(ds.getYyxe()));
		// 由于医生的工作时长是动态的，不能固定的匹配
		String dutyBeginTime = ds.getKssj().toString().substring(11, 16);
		String dutyEndTime = ds.getJssj().toString().substring(11, 16);
		info.setTimeRange(dutyBeginTime + "-" + dutyEndTime);

		info.setOutcallDate(ds.getId().getGzrq().toString().substring(0, 10));
		if (null != ds.getZjpb()) {
			if (ds.getZjpb().equals(FinalParam.EXPERT_TYPE_EXP)) {
				info.setConsultationFee((FinalParam.REGIST_FEE + FinalParam.CONSULTATION_FEE_EXP)
						+ "");
			} else {
				info.setConsultationFee((FinalParam.REGIST_FEE + FinalParam.CONSULTATION_FEE_UNEXP)
						+ "");
			}
		}
		return info;
	}

	public static List<DoctorInfo> changeDoctorList(List<Doctor> list) {
		if (list != null && list.size() > 0) {
			List<DoctorInfo> infoList = new ArrayList<DoctorInfo>();
			for (Doctor dt : list) {
				DoctorInfo info = changeDoctor(dt);

				infoList.add(info);
			}
			return infoList;
		} else {
			return null;
		}
	}

	public static DoctorInfo changeDoctor(Doctor dt) {
		DoctorInfo info = new DoctorInfo();
		info.setDoctorId(dt.getYsdm());
		info.setDoctorName(dt.getYgxm());
		if (dt.getYgxb() != null && dt.getYgxb() == 1) {
			info.setSex(dt.getYgxb().toString());
		} else if (dt.getYgxb() != null && dt.getYgxb() == 2) {
			info.setSex("0");
		} else {
			info.setSex("-1");
		}
		info.setTitle(dt.getGzmc());
		return info;
	}

	public static List<DepartmentInfo> changeDeptList(List<Department> list) {
		if (list != null && list.size() > 0) {
			List<DepartmentInfo> infoList = new ArrayList<DepartmentInfo>();
			for (Department dept : list) {
				DepartmentInfo info = changeDept(dept);

				infoList.add(info);
			}
			return infoList;
		} else {
			return null;
		}
	}

	public static DepartmentInfo changeDept(Department dept) {
		if (dept != null) {
			DepartmentInfo info = new DepartmentInfo();
			info.setDepartmentId(dept.getKsdm());
			info.setDepartmentName(dept.getKsmc());
			info.setDeptId(dept.getMzks().toString());
			return info;
		} else {
			return null;
		}
	}

	public static String getOrderTime(Timestamp kssj, int parseInt,
			Long spaceTime) {
		Long tempTime = null;
		try {
			tempTime = DateUtil.parseDateSecondFormat(
					kssj.toString().substring(0, 19)).getTime()
					+ (parseInt - 1) * spaceTime;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return DateUtil.getDateSecondFormat(new Date(tempTime));
	}

	public static String getChannelTag(Byte tag) {
		String tmp = "";
		switch (tag) {
		case FinalParam.REG_CHANNEL_LOCAL:
			tmp = "现场预约";
			break;

		case FinalParam.REG_CHANNEL_TEL:
			tmp = "电话预约";
			break;

		case FinalParam.REG_CHANNEL_WEB:
			tmp = "网上预约";
			break;

		case FinalParam.REG_CHANNEL_SMS:
			tmp = "短信预约";
			break;

		case FinalParam.REG_CHANNEL_SERVERBAR:
			tmp = "服务台预约";
			break;

		default:
			tmp = "其他渠道预约";
			break;
		}
		return tmp;
	}
}
