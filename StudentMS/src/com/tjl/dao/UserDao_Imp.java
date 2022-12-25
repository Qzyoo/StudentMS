package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

public class UserDao_Imp implements UserDao {

	private static final String SQL_USER_LOGIN = "SELECT type FROM user WHERE uname=? AND upass=?";
	private static final String SQL_USER_INSERT = "insert into user values(id,?,?,2)";
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=?";
	private static final String SQL_USER_UPDATE = "update user set upass=? where uname=?";
	private static final String SQL_USER_SELECT = "select * FROM user WHERE uname =?";

	@Override
	public int login(User user) {
//		连接数据库，创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
//		创建执行环境statement
		try {
//			创建预编译环境
			prepareStatement = conn.prepareStatement(SQL_USER_LOGIN);
//			设置sql语句中的参数
			prepareStatement.setString(1, user.getUname());
			prepareStatement.setString(2, user.getUpass());
//			执行语句
			result = prepareStatement.executeQuery();
			while (result.next()) {
//				用结果集查询当前用户权限
				int type = result.getInt("type");
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			释放
			JDBCUtils.close(conn, prepareStatement, result);
		}
//		执行sql语句Query，得到结果集对象result
		return -1;
	}

	@Override
	public boolean insert(User user) {

//		连接数据库，创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//		创建预编译环境
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_INSERT);
//			设置sql语句中的参数
			prepareStatement.setString(1, user.getUname());
			prepareStatement.setString(2, user.getUpass());
			int line = prepareStatement.executeUpdate();
//			if (line>0) {
//				return true;
//			}
			return line > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, prepareStatement, null);
		}
		return false;
	}

	@Override
	public boolean delete(String uname) {
		// TODO Auto-generated method stub
//		连接数据库，创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//		创建预编译环境
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_DELETE);
//			设置sql语句中的参数
			prepareStatement.setString(1, uname);
			int line = prepareStatement.executeUpdate();
//			if (line>0) {x
//				return true;
//			}
			return line > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, prepareStatement, null);
		}

		return false;
	}

	@Override
	public boolean update(User user) {
//		连接数据库，创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//		创建预编译环境
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_UPDATE);
//			设置sql语句中的参数
			prepareStatement.setString(1, user.getUpass());
			prepareStatement.setString(2, user.getUname());
			int line = prepareStatement.executeUpdate();
//			if (line>0) {x
//				return true;
//			}
			return line > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, prepareStatement, null);
		}
		return false;
	}

	@Override
	public User select(String uname) {
//		连接数据库，创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//		创建预编译环境
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(SQL_USER_SELECT);
//			设置sql语句中的参数
			prepareStatement.setString(1, uname);
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				uname = result.getString("uname");
				String upass = result.getString("upass");
				int type = result.getInt("type");
				return new User(id, uname, upass, type);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, prepareStatement, null);
		}
		return null;
	}

}
