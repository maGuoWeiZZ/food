package com.food.dao.impl;

import com.food.dao.FoodsDao;
import com.food.po.Foods;
import com.food.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodsDaoImpl implements FoodsDao {

    @Override
    public List<Foods> selectAllFoods() {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        String sql = "select * from foods";
        List<Foods> foodsList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                String state = resultSet.getString("state");
                int monthCount = resultSet.getInt("monthCount");
                String imgPath = resultSet.getString("imgPath");
                foodsList.add(new Foods(id,name,type,price,state,monthCount,imgPath));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return foodsList;
    }

    @Override
    public List<Foods> selectAllFoodsWithCount() {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        String sql = "select * from foods order by monthCount desc";
        List<Foods> foodsList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                String state = resultSet.getString("state");
                int monthCount = resultSet.getInt("monthCount");
                String imgPath = resultSet.getString("imgPath");
                foodsList.add(new Foods(id,name,type,price,state,monthCount,imgPath));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return foodsList;
    }

    @Override
    public Foods selectFoodsById(Integer id) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Foods foods = null;
        String sql = "select * from foods where id = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int fid = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                String state = resultSet.getString("state");
                int monthCount = resultSet.getInt("monthCount");
                String imgPath = resultSet.getString("imgPath");
                foods = new Foods(fid,name,type,price,state,monthCount,imgPath);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return foods;
    }

    @Override
    public Foods selectFoodsByName(String name) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Foods foods = null;
        String sql = "select * from foods where name = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,name);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int fid = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                String state = resultSet.getString("state");
                int monthCount = resultSet.getInt("monthCount");
                String imgPath = resultSet.getString("imgPath");
                foods = new Foods(fid,name1,type,price,state,monthCount,imgPath);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,statement,resultSet);
        }
        return foods;
    }

    @Override
    public int addFood(Foods foods) {
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "insert into foods(name,type,price,state,monthCount) values(?,?,?,?,?)";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,foods.getName());
            statement.setString(2,foods.getType());
            statement.setDouble(3,foods.getPrice());
            statement.setString(4,foods.getState());
            statement.setInt(5,foods.getMonthCount());
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
    public int deleteFoodById(Integer id) {
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "delete from foods where id = ?";
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
    public int updateFood(Foods foods) {
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "update foods set name=?,type=?,price=?,state=?,monthCount=? where id = ?";
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1,foods.getName());
            statement.setString(2,foods.getType());
            statement.setDouble(3,foods.getPrice());
            statement.setString(4,foods.getState());
            statement.setInt(5,foods.getMonthCount());
            statement.setInt(6,foods.getId());
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
