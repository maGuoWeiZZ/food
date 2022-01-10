//package com.food.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"})
//public class LoginFilter implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        String action = request.getParameter("action");
//        String servletPath = request.getServletPath();
//        System.out.println("servletPath = " + servletPath);
//
//        if (servletPath.endsWith(".css") || servletPath.endsWith(".js") ||
//                servletPath.endsWith(".html") || servletPath.endsWith(".ttf") ||
//                servletPath.endsWith(".svg") || servletPath.endsWith(".eot") ||
//                servletPath.endsWith(".woff") || servletPath.endsWith(".png") ||
//                servletPath.endsWith(".jpg") || servletPath.endsWith(".woff2") ||
//                servletPath.endsWith(".gif")) {
//            chain.doFilter(req,resp);
//            return;
//        }
//        if (action != null) {
//            if (action.equals("login")) {
//                chain.doFilter(req,resp);
//            }
//        }
//
//        Object user = request.getSession().getAttribute("user");
//        if (user != null) {
//            chain.doFilter(req, resp);
//        }else {
//            request.setAttribute("msg","请先登录在进行操作！");
//            request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
//        }
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//}
