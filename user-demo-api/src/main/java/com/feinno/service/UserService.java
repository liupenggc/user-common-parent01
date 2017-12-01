package com.feinno.service;
import java.util.List;

import com.feinno.entity.User;
/**
 * api一般只提供一个接口
 * 和一个实体类
 * @author liupenggc
 * 
 */
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