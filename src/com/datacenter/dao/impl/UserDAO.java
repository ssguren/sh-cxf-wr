package com.datacenter.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datacenter.BaseHibernateDAO;
import com.datacenter.dao.IUserDAO;
import com.model.db.User;

@Repository
public class UserDAO extends BaseHibernateDAO<User> implements IUserDAO {

	public static final String NAME = "name";
	public static final String PASS_WORD = "password";
	public static final String ID = "id";
	public static final String USER_ACCOUNT = "account";

	public List<User> findByAccount(String account) {
		return findByProperty(USER_ACCOUNT, account);
	}

	public List<User> findByName(String name) {
		return findByProperty(NAME, name);
	}

	public User findById(Integer id) {
		try {
			User instance = (User) getCacheHibernateTemplate().get(
					User.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
