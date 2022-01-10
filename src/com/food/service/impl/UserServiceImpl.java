package com.food.service.impl;

import com.food.dao.impl.UserDaoImpl;
import com.food.po.User;
import com.food.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.selectUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public int ModifyPassword(Integer uid, String password) {
        User user = userDao.selectUserById(uid);
        user.setPassword(password);
        int i = userDao.updateUser(user);
        return i;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = userDao.selectAllUsers();
        return userList;
    }

    @Override
    public User selectUserById(Integer uid) {
        User user = userDao.selectUserById(uid);
        return user;
    }

    @Override
    public User selectUserByUsername(String username) {
        User user = userDao.selectUserByUsername(username);
        return user;
    }

    @Override
    public int addUser(User user) {
        int i = userDao.addUser(user);
        return i;
    }

    @Override
    public int modifyUser(User user) {
        int i = userDao.updateUser(user);
        return i;
    }

    @Override
    public int deleteUserById(Integer uid) {
        int i = userDao.deleteUserById(uid);
        return i;
    }
}
