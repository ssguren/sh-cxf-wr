package com.test;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.db.Department;
import com.model.db.Doctor;
import com.model.db.DoctorSchedule;
import com.model.db.DoctorScheduleId;
import com.model.db.Order;
import com.model.db.Patient;
import com.model.db.PatientCard;
import com.model.db.User;
import com.servicecenter.service.db.IDepartmentService;
import com.servicecenter.service.db.IDoctorScheduleService;
import com.servicecenter.service.db.IDoctorService;
import com.servicecenter.service.db.IOrderService;
import com.servicecenter.service.db.IPatientCardService;
import com.servicecenter.service.db.IPatientService;
import com.servicecenter.service.db.IUserService;

import edu.emory.mathcs.backport.java.util.Collections;


public class JcTest {

//	@Autowired
//	private static IAdministratorMgrService administratorMgrService;
	
	@Autowired
	private static IUserService userService;
	
	@Autowired
	private static IDoctorService doctorService;
	
	@Autowired
	private static IPatientService patientService;
	
	@Autowired
	private static IDepartmentService departmentService;
	
	@Autowired
	private static IDoctorScheduleService doctorScheduleService;
	
	@Autowired
	private static IOrderService orderService;
	
	@Autowired
	private static IPatientCardService patientCardService;
	
	

	public static void main(String[] args) {
		TestStartup.init();
		
		
//		testHql();
//		testDept();
//		testDSList();
//		testOrder();
		
		
//		testDoctorSchedule();
//		testPatient();
		
//		testUser();
		testDoctor();
		
		
//		testPatientCard();
		
		
//		testCompId();
		/*
		List<Doctor> list=doctorService.findAll();
		if(null != list){
			System.out.println("count size:"+list.size());
			for (Doctor item : list) {
				System.out.println(item.getId().getYgdm()+" "+item.getId().getKsdm());
			}
		}else{
			System.out.println("list is null");
		}
		 */
		/*
		 
		administratorMgrService = (IAdministratorMgrService)TestStartup.getBean("administratorMgrService");
		List list = administratorMgrService.findAll();
		if(null != list){
			System.out.println("count size:"+list.size());
		}else{
			System.out.println("list is null");
		}
		 */
		System.exit(0);
	}



	private static void testHql() {
		orderService =(IOrderService) TestStartup.getBean("orderService");
		List<String> list=orderService.findAllDepartment();
		if(null!=list){
			for (String string : list) {
				System.out.println(string);
			}
		}else{
			System.out.println("null");
		}
	}



	private static void testCompId() {
		doctorScheduleService=(IDoctorScheduleService) TestStartup.getBean("doctorScheduleService");
		DoctorSchedule sch=doctorScheduleService.findByDoctorCode("319").get(0);
		System.out.println(sch.getId().getKsdm());
	}



	private static void testPatientCard() {
		patientCardService=(IPatientCardService) TestStartup.getBean("patientCardService");
		//240856 王光荣 440620211019545
		PatientCard card=patientCardService.findByPatientId("240856");
		System.out.println(card.getIckh());
	}



	private static void testOrder() {
		orderService =(IOrderService) TestStartup.getBean("orderService");
		String doctorId="319";
		String beginTime="2013-02-23 08:00:00";
		String endTime="2013-02-23 12:00:00";
		String regId="41";
		List<Order> list=orderService.findByOrderParam(doctorId, Timestamp.valueOf(beginTime), Timestamp.valueOf(endTime),regId);
		if(list!=null&&list.size()>0){
			for (Order order : list) {
				System.out.println(order.getKsdm()+"||"+order.getYsdm()+"||"+order.getYyrq());
			}
		}else{
			System.out.println("nullllllllllllllllll");
		}
//		List<Order> list=orderService.findByPatientId("2391529");
//		Order order=orderService.findById(304746);
	}



	private static void testDSList() {
		doctorScheduleService =(IDoctorScheduleService) TestStartup.getBean("doctorScheduleService");
		String beginDate="2013-02-01 00:00:00";
		String endDate="2013-02-01 23:59:59";
		List<DoctorSchedule> list=doctorScheduleService.findByDate(Timestamp.valueOf(beginDate), Timestamp.valueOf(endDate));
		for (DoctorSchedule ds : list) {
			System.out.println(ds.getId().getKsdm()+"||"+ds.getId().getYsdm()+"||"+ds.getYyxe()+"||"+ds.getKssj());
		}
		System.out.println(list.size());
	}



	private static void testDoctorSchedule() {
		doctorScheduleService =(IDoctorScheduleService) TestStartup.getBean("doctorScheduleService");
		DoctorScheduleId id=new DoctorScheduleId();
		String dataTime="2013-02-01 00:00:00";
		String ksdm="02";
		String ysdm="319";
		String zblb="1";
		id.setKsdm(ksdm);
		id.setYsdm(ysdm);
		id.setGzrq(Timestamp.valueOf(dataTime));
		id.setZblb(Short.parseShort(zblb));
		DoctorSchedule ds=doctorScheduleService.findByDoctorId(id);
		System.out.println(ds.getYyxe()+" "+ds.getJssj().toString());
	}



	private static void testDept() {
		departmentService=(IDepartmentService) TestStartup.getBean("departmentService");
		List<Department> list=departmentService.findAll();
		for (Department department : list) {
			System.out.println(department.getKsdm()+" "+department.getKsmc());
		}
	}



	private static void testPatient() {
		patientService=(IPatientService) TestStartup.getBean("patientService");
		Patient p=patientService.findByInfo("440620211019545", "王光荣");

//		List<Patient> list=patientService.findByName("test");
//		for (Patient p : list) {
			System.out.println(p.getBrid()+" "+p.getBrxm()+" "+p.getSfzh());
//		}
	}



	private static void testDoctor() {
		
		doctorService =(IDoctorService) TestStartup.getBean("doctorService");
		List<Doctor> list=doctorService.findByDeptCode("29");
		for (Doctor dt : list) {
			System.out.println(dt.getYgxm()+" "+dt.getYsdm()+" "+dt.getKsdm()+" "+dt.getYgxb()+" "+dt.getGzmc());
		}
		
	}



	private static void testUser() {
		userService =(IUserService) TestStartup.getBean("userService");
		List<User> list=userService.findAll();
		if(null != list){
			System.out.println("count size:"+list.size());
			for (User user : list) {
				System.out.println(user.getName()+" "+user.getUserAccount());
			}
		}else{
			System.out.println("list is null");
		}
	}
	
}
