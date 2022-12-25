package com.tjl.dao;

import com.tjl.bean.User;

public interface UserDao {

	/**
	 * 验证登录的方法
	 * 
	 * @param user uname upass
	 * @return int类型 -1表示登录失败 1表示管理员登录 2表示学生登录
	 */
	int login(User user);

	/**
	 * 用来添加学生信息的方法
	 * 
	 * @param user要添加的对象 包含账户和密码
	 * @return 如果添加成功返回true 否则返回false
	 */
	boolean insert(User user);// 抽象方法

	/**
	 * 用来删除学生信息的方法
	 * 
	 * @param uname要删除的对象，包含账户和密码
	 * @return 如果删除成功返回TRUE 否则返回FALSE
	 */
	boolean delete(String uname);

	/**
	 * 用来修改学生信息的方法
	 * 
	 * @param uname要修改的对象，包含账户和密码
	 * @return 如果删除成功返回TRUE 否则返回FALSE
	 */
	boolean update(User user);

	/**
	 * 用来查询学生信息的方法
	 * 
	 * @param uname要查询的学生账号
	 * @return 查询成功返回user，查询失败返回null
	 */
	User select(String uname);
}
