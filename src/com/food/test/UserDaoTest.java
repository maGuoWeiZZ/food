package com.food.test;


import com.food.dao.impl.UserDaoImpl;
import com.food.po.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void selectAllUsers() {
        List<User> userList = userDao.selectAllUsers();
        System.out.println(userList);
    }

    @Test
    public void selectUserById() {
        User user = userDao.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectUserByUsernameAndPassword() {
        User user = userDao.selectUserByUsernameAndPassword("admin","admin");
        System.out.println(user);
    }

    @Test
    public void addUser() {
        User user = new User(null, "test", "test", "张三", "18765467730", "123iju@163.com");
        int i = userDao.addUser(user);
        if (i > 0) {
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void deleteUserById() {
        int i = userDao.deleteUserById(2);
        if (i > 0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void updateUser() {
        User user = new User(3, "test", "test", "张si", "18765467730", "123iju@163.com");
        int i = userDao.updateUser(user);
        if (i > 0) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
}
