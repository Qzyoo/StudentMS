package com.tjl.controller;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.view.View;

public class Control {

	public static void main(String[] args) {
//		给用户展示登录页面
		while (true) {
			User user = View.indexView();
			UserDao_Imp userDao_Imp = new UserDao_Imp();
			int type = userDao_Imp.login(user);
			switch (type) {
			case -1:
//				System.out.println("输入有误，请重新输入!");
				break;
			case 1:
//				System.out.println("恭喜管理员登录！");
				managerServer();
				break;
			case 2:
//				System.out.println("恭喜学生登录！");
				studentServer(user);
				break;
			default:
				break;
			}
		}

	}

	private static void managerServer() {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		while (true) {
			// 展示管理员菜单视图
			int item = View.managerMenuView();
			boolean flag;
			switch (item) {
			case 0:// 退出
				System.exit(-1);
				break;
			case 1:// 添加學生
				User user = View.addMenuView();
				flag = userDao_Imp.insert(user);
				System.out.println(flag ? "添加成功！" : "添加失败！");
				break;
			case 2:// 删除學生
				String uname = View.deleteMenuView();
				flag = userDao_Imp.delete(uname);
				System.out.println(flag ? "删除成功！" : "删除失败！");
				break;
			case 3:// 修改學生
				User user2 = View.updateMenuView();
				flag = userDao_Imp.update(user2);
				System.out.println(flag ? "修改成功！" : "修改失败！");
				break;
			case 4:// 查找學生
				String suname = View.selectMenuView();
				User user3 = userDao_Imp.select(suname);
				View.printUser(user3);
				break;
			default:
				break;
			}
		}

	}

	private static void studentServer(User user) {
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		while (true) {
			// 展示学生菜单视图
			int item = View.studentMenuView();
			boolean flag;
			switch (item) {
			case 0:// 退出
				System.exit(-1);
				break;
			case 1:// 修改學生
				User user2 = View.studentUpdateMenuView(user.getUname());
				flag = userDao_Imp.update(user2);
				System.out.println(flag ? "修改成功！" : "修改失败！");
				break;
			default:
				break;
			}
		}

	}

}
