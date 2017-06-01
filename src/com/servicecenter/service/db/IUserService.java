package com.servicecenter.service.db;

import java.util.List;

import com.model.db.User;
import com.servicecenter.IDAOBasedService;


public interface IUserService extends IDAOBasedService<User, Integer> {

	public List<User> findByName(String name);
	
	public List<User> findByAccount(String account);
}
