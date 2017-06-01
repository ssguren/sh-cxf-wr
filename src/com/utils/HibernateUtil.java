package com.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final Log log = LogFactory.getLog(HibernateUtil.class);

	private static final SessionFactory sessionFactory;

	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	static {
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			log.error(MiscUtil.traceInfo(e));
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session currentSession() throws HibernateException {
		Session s = session.get();
		if (s == null) {
			s = sessionFactory.getCurrentSession();
			session.set(s);
		}

		return s;
	}

	public static Session openSession() throws HibernateException {
		Session s = session.get();
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}

		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = session.get();
		if (s != null && s.isOpen())
			s.close();

		session.set(null);
	}
}
