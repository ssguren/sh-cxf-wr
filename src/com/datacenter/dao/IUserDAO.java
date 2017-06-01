package com.datacenter.dao;

import java.util.List;

import com.datacenter.IBaseDAO;
import com.model.db.User;


public interface IUserDAO extends IBaseDAO<User, Integer> {

	public List<User> findByName(String name);

	public List<User> findByAccount(String account);
}
