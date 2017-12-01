package com.feinno.service;
import java.util.List;
//盖章:在dao的接口下

import com.feinno.annotation.HBaseDao;
import com.feinno.entity.User;

@HBaseDao
public interface UserService {
	//查询所有
	List<User> findAll();
	//新增数据
	void save(User user);
	//根据id查询
	User findByRowKey(String id);
	//修改
	void update(User cost);
	//删除
	void delete(String id);
}