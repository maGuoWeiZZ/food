package com.food.web;

import com.food.po.User;
import com.food.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //通过反射判断调用哪个方法
        String action = request.getParameter("action");
        Class clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录方法调用");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user = userService.login(username, password);
        if (user != null) { //登录成功
//                用户对象信息存入session
            request.getSession().setAttribute("user", user);
//                设置身份
            if (user.getUid() == 1) {
                request.getSession().setAttribute("identity", "超级管理员");
            } else {
                request.getSession().setAttribute("identity", "普通管理员");
            }
//                登录时间
            String loginTime = new SimpleDateFormat("YYYY年MM月dd日HH时mm分ss秒").format(new Date());
            request.getSession().setAttribute("loginTime", loginTime);
//                登录ip
            request.getSession().setAttribute("ip", request.getRemoteAddr());
//                重定向到管理员主页
            request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
        } else {
//                登录失败
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
        }
    }

    //退出登录
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
    }

    //修改密码
    protected void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        Integer uid = Integer.parseInt(request.getParameter("uid"));
        int i = userService.ModifyPassword(uid, newPassword);
        if (i > 0) {
            request.setAttribute("msg", "修改密码成功，请重新登录");
            request.getSession().invalidate();
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            return;
        } else {
            return;
        }
    }

    //查询所有管理员列表
    protected void selectAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/pages/admin_list.jsp").forward(request, response);
    }

    //添加管理员
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        User user = new User(null, username, password, realName, phone, email);
        int i = userService.addUser(user);
        if (i > 0) {
            selectAllUser(request, response);
        } else {
            return;
        }
    }

    //修改管理员列表
    protected void modifyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.selectAllUser();
        request.setAttribute("usersList", userList);
        request.getRequestDispatcher("/pages/modify_admin_list.jsp").forward(request, response);
    }

    //修改管理员详情页数据回显
    protected void modifyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        User user = userService.selectUserById(uid);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/pages/modify_admin_do.jsp").forward(request, response);
    }

    //修改管理员信息
    protected void modifyUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int uid = Integer.parseInt(request.getParameter("uid"));
        User user = new User(uid, username, password, realName, phone, email);
        int i = userService.modifyUser(user);
        if (i > 0) {
            modifyList(request, response);
        } else {
            return;
        }
    }


    //删除管理列表
    protected void deleteUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/pages/delete_admin_list.jsp").forward(request, response);
    }


    //删除管理员信息
    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        int i = userService.deleteUserById(uid);
        if (i > 0) {
            deleteUserList(request, response);
        } else {
            return;
        }
    }

    //检测用户名是否存在
    protected void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = userService.selectUserByUsername(username);
        if (user != null) {
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
