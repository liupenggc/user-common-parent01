package com.feinno.dao;
import java.util.List;

import com.feinno.annotation.HBaseDao;
import com.feinno.entity.User;
//盖章:在dao的接口下
@HBaseDao
public interface UserDao {
	//查询所有  
	List<User> scanResult(String tableName);
	//新增数据 
	void addData(String tableName,String rowKey, String[] column, String[] value);
	//根据id查询
	User getResult(String tableName, String rowKey);
	//删除
	void deleteAllColumn(String tableName, String rowKey);
}