package com.food.test;


import com.food.po.User;
import com.food.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    private UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void login() {
        User user = userService.login("admin", "admin");
        if (user != null) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    @Test
    public void ModifyPassword() {
        int i = userService.ModifyPassword(3, "123456");
        if (i > 0) {
            System.out.println("修改密码成功");
        } else {
            System.out.println("修改密码失败");
        }
    }

    @Test
    public void selectAllUser() {
        List<User> userList = userService.selectAllUser();
        for (User user : userList) {
            System.out.println(user + "\n");
        }
    }

    @Test
    public void addUser() {
        User user = new User(null, "lily", "123456", "Lily", "18765453365", "uhygft@163.com");
        int i = userService.addUser(user);
        if (i > 0) {
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
}
