package com.food.dao.impl;

import com.food.dao.UserDao;
import com.food.po.User;
import com.food.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> selectAllUsers() {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        String sql = "select * from user";
        List<User> userList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String realName = resultSet.getString("realName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                userList.add(new User(uid,username,password,realName,phone,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return userList;
    }

    @Override
    public User selectUserById(Integer id) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        User user = null;
        String sql = "select * from user where uid = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String realName = resultSet.getString("realName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                user = new User(uid,username,password,realName,phone,email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return user;
    }

    @Override
    public User selectUserByUsername(String username) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        User user = null;
        String sql = "select * from user where username = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String username1 = resultSet.getString("username");
                String password = resultSet.getString("password");
                String realName = resultSet.getString("realName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                user = new User(uid,username1,password,realName,phone,email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return user;
    }

    @Override
    public User selectUserByUsernameAndPassword(String username,String password) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        User user = null;
        String sql = "select * from user where username = ? and password = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                String realName = resultSet.getString("realName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                user = new User(uid,username1,password1,realName,phone,email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "insert into user values(null,?,?,?,?,?)";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getRealName());
            statement.setString(4,user.getPhone());
            statement.setString(5,user.getEmail());
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement);
        }
        return 0;
    }

    @Override
    public int deleteUserById(Integer id) {
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "delete from user where uid = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement);
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "update user set username=?,password=?,realName=?,phone=?,email=? where uid = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getRealName());
            statement.setString(4,user.getPhone());
            statement.setString(5,user.getEmail());
            statement.setInt(6,user.getUid());
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement);
        }
        return 0;
    }
}
