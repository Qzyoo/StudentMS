package com.tjl.test;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest {

//	测试登录页视图。
	@Test
	public void indexViewTest() throws Exception {
		User user1 = View.indexView();
		System.out.println(user1);

	}

//	测试管理员菜单视图
	@Test
	public void managerMenuViewTest() throws Exception {
		int item = View.managerMenuView();
		System.out.println(item);
	}

//	测试添加学生信息试图
	@Test
	public void addMenuViewTest() throws Exception {
		User user = View.addMenuView();
		System.out.println(user);
	}
}
