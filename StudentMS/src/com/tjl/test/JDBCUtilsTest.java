package com.tjl.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;

//import com.mysql.jdbc.Connection;

import com.tjl.jdbc.JDBCUtils;

public class JDBCUtilsTest {
	@Test
	public void jdbcConnectionTest() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select * from info");
		while (result.next()) {
			System.out.println(result.getString("uname"));
		}
	}

//	测试登录
	@Test
	public void loginTest() throws Exception {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("张三", "zs111");
		int type = userDao_Imp.login(user);
		System.out.println(type);
	}

//	测试插入
	@Test
	public void insertTest() throws Exception {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("测试", "ww333");
		boolean flag = userDao_Imp.insert(user);
		System.out.println(flag);
	}

//	测试删除
	@Test
	public void deleteTest() throws Exception {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		String uname = "张三";
		boolean flag = userDao_Imp.delete(uname);
		System.out.println(flag);
	}

//	测试更新
	@Test
	public void updateTest() throws Exception {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("蛐蛐", "ququ");
		boolean flag = userDao_Imp.update(user);
		System.out.println(flag);
	}

//	测试查询
	@Test
	public void selectTest() throws Exception {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("哈哈", "123");
		User user2 = userDao_Imp.select(user.getUname());
		System.out.println(user2);
	}

}
