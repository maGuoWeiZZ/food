<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
  request.setAttribute("path", basePath);
//    跳转登录页面
  response.sendRedirect(basePath + "pages/login.jsp");
%>
