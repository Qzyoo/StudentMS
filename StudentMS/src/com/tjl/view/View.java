package com.tjl.view;

import java.util.Scanner;

import com.tjl.bean.User;

public class View {

	private static Scanner input = new Scanner(System.in);

//	首页视图
	public static User indexView() {
		System.out.println("*****************************************");
		System.out.println("*********\t学生管理系统\t*********");
		System.out.println("*********\t请根据提示操作\t*********");
		System.out.println("*********\t请输入账号：\t*********");
		String uname = input.nextLine();
		System.out.println("*********\t请输入密码：\t*********");
		String upass = input.nextLine();
		System.out.println("*****************************************");

		return new User(uname, upass);
	}

//	管理员菜单视图
	public static int managerMenuView() {
		System.out.println("*****************************************");
		System.out.println("*********\t欢迎管理员回家\t*********");
		System.out.println("*********\t请根据提示操作\t*********");
		System.out.println("*********\t0.退出\t*********");
		System.out.println("*********\t1.添加学生信息\t*********");
		System.out.println("*********\t2.删除学生信息\t*********");
		System.out.println("*********\t3.修改学生信息\t*********");
		System.out.println("*********\t4.查询学生信息\t*********");
//		获取用户输入信息
		String type = input.nextLine();
//		将获取到的数据转换为int类型
		int item = Integer.parseInt(type);
//		判断用户输入是否在0-4之间，如果超出范围，提示用户重新输入，并留在视图页面
		if (item < 0 || item > 4) {
			System.out.println("输入错误，重新输入");
//			通过再次调用该方法来回到视图菜单：回调
			return managerMenuView();
		}
//		如果输入正确，将用户输入的选项返回
		System.out.println("*****************************************");
		return item;
	}

//	学生菜单视图
	public static int studentMenuView() {
		System.out.println("*****************************************");
		System.out.println("*********\t欢迎学生登录\t*********");
		System.out.println("*********\t请根据提示操作\t*********");
		System.out.println("*********\t0.退出\t*********");
		System.out.println("*********\t1.修改学生信息\t*********");
//		获取用户输入信息
		String type = input.nextLine();
//		将获取到的数据转换为int类型
		int item = Integer.parseInt(type);
//		判断用户输入是否在0-1之间，如果超出范围，提示用户重新输入，并留在视图页面
		if (item != 0 && item != 1) {
			System.out.println("输入错误，重新输入");
//			通过再次调用该方法来回到视图菜单：回调
			return studentMenuView();
		}
//		如果输入正确，将用户输入的选项返回
		System.out.println("*****************************************");
		return item;
	}

	/**
	 * 添加学生信息视图
	 * 
	 * @return 新的User对象 User(uname,upass)
	 */
	public static User addMenuView() {
		System.out.println("*****************************************");
		System.out.println("*********\t请根据提示操作\t*********");
		System.out.println("*********\t请输入账号：\t*********");
		String uname = input.nextLine();
		System.out.println("*********\t请输入密码：\t*********");
		String upass = input.nextLine();
		System.out.println("*****************************************");
		return new User(uname, upass);
	}

	/**
	 * 删除学生信息菜单视图
	 * 
	 * @return uname返回要删除的学生账号
	 */
	public static String deleteMenuView() {
		System.out.println("*****************************************");
		System.out.println("*********\t请根据提示操作\t*********");
		System.out.println("*********\t请输入要删除的学生账号：\t*********");
		String uname = input.nextLine();
		System.out.println("*****************************************");
		return uname;
	}

	/**
	 * 修改学生信息视图
	 * 
	 * @return User(uname) 旧账户uname对应新密码upass
	 */
	public static User updateMenuView() {
		System.out.println("*****************************************");
		System.out.println("*********\t请根据提示操作\t*********");
		System.out.println("*********\t请输入要更新的学生账号：\t*********");
		String uname = input.nextLine();
		System.out.println("*********\t请输入新的密码：\t*********");
		String upass = input.nextLine();
		System.out.println("*****************************************");
		return new User(uname, upass);
	}

	/**
	 * 查询学生信息菜单视图
	 * 
	 * @return uname 返回要删除的学生姓名
	 */
	public static String selectMenuView() {
		System.out.println("*****************************************");
		System.out.println("*********\t请根据提示操作\t*********");
		System.out.println("*********\t请输入要查询的学生账号：\t*********");
		String uname = input.nextLine();
		System.out.println("*****************************************");
		return uname;
	}

	/**
	 * 学生修改自己信息视图
	 * 
	 * @return User(uname) 旧账户uname对应新密码upass
	 */
	public static User studentUpdateMenuView(String uname) {
		System.out.println("*****************************************");
		System.out.println("*********\t请输入新的密码：\t*********");
		String upass = input.nextLine();
		System.out.println("*****************************************");
		return new User(uname, upass);
	}

//	输出学生信息的方法
	public static void printUser(User user) {
		System.out.println("用户ID：" + user.getId());
		System.out.println("用户名：" + user.getUname());
		System.out.println("用户密码：" + user.getUpass());
		if (user.getType() == 1) {
			System.out.println("用户权限：管理员");
		} else {
			System.out.println("用户权限：学生");
		}

	}
}
