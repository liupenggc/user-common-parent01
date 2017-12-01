package com.feinno.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.feinno.dao.UserDao;
import com.feinno.entity.User;
import com.feinno.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	//注入dao
	@Resource
	private UserDao userDao;
	@Override
	public List<User> findAll() {
		return userDao.scanResult("liupenggc:user");
	}

	@Override
	public void save(User user) {
		String[] column = {"id","name","age","sex"};
		String[] value = {user.getId(),user.getName(),user.getAge(),user.getSex()};
		userDao.addData("liupenggc:user",user.getId(),column,value);
	}

	@Override
	public User findByRowKey(String RowKey) {
		return userDao.getResult("liupenggc:user", RowKey);
	}
	
	@Override
	public void delete(String id) {
		userDao.deleteAllColumn("liupenggc:user",id);
	}

	@Override
	public void update(User user) {
		String[] column = {"name","age","sex"};
		String[] value = {user.getName(),user.getAge(),user.getSex()};
		userDao.addData("liupenggc:user",user.getId(),column,value);
	}
}
