package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TestHql extends HibernateDaoSupport {
	public static void main(String[] args) {
		TestHql test=new TestHql();
		List list=test.method();
		if(null!=list){
			System.out.println(list.size());
		}else{
			System.out.println("null");
		}
	}
	public  List method(){
		List list=new ArrayList();
		Session session=getSession();
		String hql="select order.ksdm,dt.ksdm from Order as order,Department as dt where order.ksdm=dt.ksdm";
		list=session.createQuery(hql).list();
		return list;
	}
}
