package com.food.service;

import com.food.po.User;

import java.util.List;

public interface UserService {

    /**
     * @Description 管理员登录。成功返回该对象，失败返回null
     * @author maGuoWei
     * @date 2021/11/23 23:01
     * @param username:
     * @param password:
     * @return: com.food.po.User
     */
    User login(String username,String password);

    /**
     * @Description 修改密码
     * @author maGuoWei
     * @date 2021/11/24 11:24
     * @param uid:
     * @param password:
     * @return: int
     */
    int ModifyPassword(Integer uid,String password);

    /**
     * @Description 查询所有管理员信息
     * @author maGuoWei
     * @date 2021/11/26 17:53
     * @return: java.util.List<com.food.po.User>
     */
    List<User> selectAllUser();

    /**
     * @Description 根据uid查询用户信息
     * @author maGuoWei
     * @date 2021/11/26 19:44
     * @param uid:
     * @return: com.food.po.User
     */
    User selectUserById(Integer uid);

    /**
     * @Description 根据用户名查询用户信息
     * @author maGuoWei
     * @date 2021/11/26 19:44
     * @param username:
     * @return: com.food.po.User
     */
    User selectUserByUsername(String username);

    /**
     * @Description 添加管理信息
     * @author maGuoWei
     * @date 2021/11/26 18:16
     * @param user:
     * @return: int
     */
    int addUser(User user);

    /**
     * @Description 修改用户信息
     * @author maGuoWei
     * @date 2021/11/26 19:52
     * @param user:
     * @return: int
     */
    int modifyUser(User user);

    /**
     * @Description 根据用户编号删除用户
     * @author maGuoWei
     * @date 2021/11/26 20:07
     * @param uid:
     * @return: int
     */
    int deleteUserById(Integer uid);



}
