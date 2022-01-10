package com.food.web;

import com.food.po.Foods;
import com.food.service.impl.FoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FoodsServlet", urlPatterns = "/foodsServlet")
public class FoodsServlet extends HttpServlet {

    private FoodsServiceImpl foodsService = new FoodsServiceImpl();

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

    //查询所有餐饮商品信息
    protected void selectAllFoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Foods> foodsList = foodsService.selectAllFoods();
        request.setAttribute("foodsList", foodsList);
        request.getRequestDispatcher("/pages/all_foods.jsp").forward(request, response);

    }

    //按名称查询餐饮商品信息
    protected void selectFoodsByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("按名称查询餐饮商品信息方法调用");
        String name = request.getParameter("name");
        System.out.println(name);
        Foods foods = foodsService.selectFoodsByName(name);
        request.setAttribute("foods", foods);
        System.out.println(foods);
        request.getRequestDispatcher("/pages/single_foods.jsp").forward(request, response);
    }

    //添加餐饮商品信息
    protected void addFoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("添加餐饮商品信息方法调用");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        Foods foods = new Foods();
        foods.setName(name);
        foods.setPrice(price);
        foods.setMonthCount(0);
        foods.setState("在售");
        foods.setType(type);
        System.out.println(foods);
        int i = foodsService.addFoods(foods);
        if (i > 0) {
//            selectAllFoods(request,response);
            response.sendRedirect(request.getContextPath() + "/foodsServlet?action=selectAllFoods");
        } else {
            return;
        }
    }

    //修改餐饮商品信息列表
    protected void modifyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Foods> foodsList = foodsService.selectAllFoods();
        request.setAttribute("foodsList", foodsList);
        request.getRequestDispatcher("/pages/modify_list.jsp").forward(request, response);
    }

    //修改餐饮商品信息详情页并数据回显
    protected void modifyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Foods foods = foodsService.selectFoodsById(id);
        request.setAttribute("foods", foods);
        request.getRequestDispatcher("/pages/modify_do.jsp").forward(request, response);
    }

    //修改餐饮商品信息
    protected void modifyFoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int count = Integer.parseInt(request.getParameter("count"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        String state = request.getParameter("state");
        String[] monthCounts = request.getParameterValues("monthCount");
        if (monthCounts != null && monthCounts[0].equals("true")) {
            count = 0;
        }
        int i = foodsService.ModifyFoods(new Foods(id, name, type, price, state, count));
        if (i > 0) {
//            modifyList(request,response);
            response.sendRedirect(request.getContextPath() + "/foodsServlet?action=modifyList");
        } else {
            return;
        }
    }

    //删除餐饮商品列表
    protected void deleteFoodsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Foods> foodsList = foodsService.selectAllFoods();
        request.setAttribute("foodsList", foodsList);
        request.getRequestDispatcher("/pages/delete_list.jsp").forward(request, response);
    }

    //删除餐饮商品列表
    protected void deleteFoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int i = foodsService.deleteFoodsById(id);
        if (i > 0) {
//            deleteFoodsList(request,response);
            response.sendRedirect(request.getContextPath() + "/foodsServlet?action=deleteFoodsList");
        } else {
            return;
        }
    }

    //销量统计
    protected void countFoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("销量统计调用");
        List<Foods> foodsList = foodsService.selectAllFoodsOrderByCount();
        request.setAttribute("foodsList", foodsList);
        int count = 0;
        for (int i = 0; i < foodsList.size(); i++) {
            count += foodsList.get(i).getMonthCount();
        }
        request.setAttribute("count",count);
        request.getRequestDispatcher("/pages/count.jsp").forward(request, response);
    }

    //检测商品名称是否存在
    protected void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Foods foods = foodsService.selectFoodsByName(name);
        if (foods != null) {
            response.getWriter().write("false");
        }else {
            response.getWriter().write("true");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
