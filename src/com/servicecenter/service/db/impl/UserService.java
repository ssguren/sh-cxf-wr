package com.servicecenter.service.db.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.IUserDAO;
import com.model.db.User;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IUserService;


@Service
@Transactional(readOnly = true)
public class UserService extends DAOBasedService<User, Integer, IUserDAO>
		implements IUserService {

	public List<User> findByAccount(String account) {
		if (dao != null)
			return dao.findByAccount(account);
		return null;
	}

	public List<User> findByName(String name) {
		if (dao != null)
			return dao.findByName(name);
		return null;
	}

}
