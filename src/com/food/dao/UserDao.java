package com.food.dao;

import com.food.po.User;

import java.util.List;

public interface UserDao {

    /**
     * @Description 查询所有管理员信息
     * @author maGuoWei
     * @date 2021/11/23 22:48
     * @return: java.util.List<com.food.po.User>
     */
    List<User> selectAllUsers();

    /**
     * @Description 按id查询管理员信息
     * @author maGuoWei
     * @date 2021/11/23 22:49
     * @param id:
     * @return: com.food.po.User
     */
    User selectUserById(Integer id);

    /**
     * @Description 按用户名查询管理员信息
     * @author maGuoWei
     * @date 2021/11/23 22:49
     * @param username:
     * @return: com.food.po.User
     */
    User selectUserByUsername(String username);


   /**
    * @Description 按用户名和密码查询管理员信息
    * @author maGuoWei
    * @date 2021/11/23 22:55
    * @param username:
    * @param password:
    * @return: com.food.po.User
    */
    User selectUserByUsernameAndPassword(String username,String password);


    /**
     * @Description 添加管理员信息
     * @author maGuoWei
     * @date 2021/11/23 22:50
     * @param user:
     * @return: int
     */
    int addUser(User user);

    /**
     * @Description 按id删除管理员信息
     * @author maGuoWei
     * @date 2021/11/23 22:50
     * @param id:
     * @return: int
     */
    int deleteUserById(Integer id);

    /**
     * @Description 修改管理员信息
     * @author maGuoWei
     * @date 2021/11/23 22:50
     * @param user:
     * @return: int
     */
    int updateUser(User user);

}
