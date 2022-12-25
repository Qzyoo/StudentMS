package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {

		try {
			// 1.加载MySQL驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
			// 2.连接数据库,获得连接对象
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentinfo?serverTimezone=GMT%2B8", "root", "wkyykqc66gbbt");
			System.out.println("数据库连接成功");
			// 3.创建执行环境
			Statement statement = conn.createStatement();
			// 4.执行sql语句得到结果集
			ResultSet result = statement.executeQuery("select * from info");
			while (result.next()) {
				System.out.print(result.getInt("id") + " ");
				System.out.print(result.getString("uname") + " ");
				System.out.println(result.getString("upass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
			System.out.println("数据库连接失败");

		}
	}

}
