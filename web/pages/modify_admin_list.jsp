<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("path", basePath);
%>
<%
    if (session.getAttribute("user") == null) {
        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>餐饮后台管理系统主页</title>
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/style.css">
</head>
<body>
<div class="skin-default" id="wrapper">
    <header class="navbar-header">
        <div class="brand">
            <a class="navbar-brand" href="#" title="AlphaAdmin">欢迎，${sessionScope.user.username}</a>
        </div>
        <div class="navbar">
            <i class="sidebar-toggle iconfont icon-menu" data-toggle="push-menu" role="button">
            </i>
            <div class="navbar-menu pull-right">
                <ul class="nav navbar-nav">


                    <li class="dropdown user">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                           title="用户">${sessionScope.user.username}</a>
                        <ul class="dropdown-menu">
                            <li>
                                <a data-toggle="modal" data-target=".menu-setpassword" href="#" title="修改密码">
                                    <i class="iconfont icon-menu-user"></i>
                                    修改密码
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a data-toggle="modal" data-target=".menu-logout" href="#" title="登出">
                                    <i class="iconfont icon-power"></i>
                                    退出登录
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <!-- 左侧导航 -->
    <aside class="main-sidebar">
        <div class="user-panel">
            <div class="image pull-left">
                <img src="${path}assets/avatars/avatars.png" alt="">
            </div>
            <div class="info pull-right">
                <p class="title">${sessionScope.user.username}</p>
                <strong>${sessionScope.identity}</strong>
            </div>
        </div>
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <%--主页--%>
                <li>
                    <a href="${path}pages/index.jsp" title="主页">
                        <i class="iconfont icon-home"></i>
                        <small>主页</small>
                    </a>
                </li>
                <%--查询餐饮商品--%>
                <li class="treeview">
                    <a href="#" title="查询餐饮商品">
                        <i class="iconfont icon-search"></i>
                        <small>查询餐饮商品</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="${path}foodsServlet?action=selectAllFoods">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>查询所有餐饮商品</small>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="modal" data-target=".menu-select" href="#">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>按餐饮商品名称查询</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--添加餐饮商品--%>
                <li class="treeview">
                    <a href="${path}pages/add.jsp" title="添加餐饮商品">
                        <i class="iconfont icon-plus"></i>
                        <small>添加餐饮商品</small>
                    </a>
                </li>
                <%--修改餐饮商品信息--%>
                <li class="treeview">
                    <a href="${path}foodsServlet?action=modifyList" title="修改餐饮商品信息">
                        <i class="iconfont icon-pencil"></i>
                        <small>修改餐饮商品信息</small>
                    </a>
                </li>
                <%--删除餐饮商品信息--%>
                <li class="treeview">
                    <a href="${path}foodsServlet?action=deleteFoodsList" title="删除餐饮商品信息">
                        <i class="iconfont icon-remove"></i>
                        <small>删除餐饮商品信息</small>
                    </a>
                </li>
                <%--销量统计--%>
                <li class="treeview">
                    <a href="${path}foodsServlet?action=countFoods" title="销量统计">
                        <i class="iconfont icon-chart"></i>
                        <small>销量统计</small>
                    </a>
                </li>
                <%--管理普通管理员--%>
                <c:if test="${sessionScope.user.uid == 1}">
                    <li class="treeview active">
                        <a href="#" title="管理普通管理员">
                            <i class="iconfont icon-login-user"></i>
                            <small>管理普通管理员</small>
                            <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                        </a>
                        <ul class="treeview-menu">
                            <li>
                                <a href="${path}userServlet?action=selectAllUser">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>查询普通管理员</small>
                                </a>
                            </li>
                            <li>
                                <a href="${path}pages/add_admin.jsp">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>添加普通管理员</small>
                                </a>
                            </li>
                            <li class="active">
                                <a href="${path}userServlet?action=modifyList">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>修改普通管理员</small>
                                </a>
                            </li>
                            <li>
                                <a href="${path}userServlet?action=deleteUserList">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>删除普通管理员</small>
                                </a>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <%--修改密码--%>
                <li>
                    <a data-target=".menu-setpassword" data-toggle="modal" href="#" title="修改密码">
                        <i class="iconfont icon-lock"></i>
                        <small>修改密码</small>
                    </a>
                </li>
                <%--退出登录--%>
                <li>
                    <a data-target=".menu-logout" data-toggle="modal" href="#" title="退出登录">
                        <i class="iconfont icon-power"></i>
                        <small>退出登录</small>
                    </a>
                </li>
            </ul>
        </section>
    </aside>
    <div class="page-wrapper">
        <div class="page-header">
            <h1 class="title">
                餐饮后台管理系统
                <small>管理员端</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <a href="#" title="主页">
                        <i class="iconfont icon-home"></i>
                        <small>主页</small>
                    </a>
                </li>
            </ol>
        </div>
        <div class="row widget">
            <section class="col-lg-12 widget-drag">
                <div class="box table">
                    <div class="box-header" data-trigger="drag">
                        <h3 class="box-title">
                            修改管理员信息
                        </h3>
                        <div class="box-tools pull-right">
                            <button class="" type="button" data-toggle="collapse">
                                <i class="iconfont icon-minus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body" id="table">
                        <div class="table-responsive" style="overflow: auto;height: 500px;">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="text text-center">管理员编号</th>
                                    <th class="text text-center">管理员用户名</th>
                                    <th class="text text-center">真实姓名</th>
                                    <th class="text text-center">电话号码</th>
                                    <th class="text text-center">电子邮箱</th>
                                    <th class="text text-center">管理员权限</th>
                                    <th class="text text-center">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.usersList}" var="user">
                                    <form action="${path}userServlet?action=modifyDo" method="post">
                                        <tr>
                                            <input type="hidden" name="uid" value="${user.uid}">
                                            <td class="text text-center"
                                                style="vertical-align: middle;">${user.uid}</td>
                                            <td class="text text-center"
                                                style="vertical-align: middle;">${user.username}</td>
                                            <td class="text text-center"
                                                style="vertical-align: middle;">${user.realName}</td>
                                            <td class="text text-center" style="vertical-align: middle;">
                                                    ${user.phone}</td>
                                            <td class="text text-center"
                                                style="vertical-align: middle;">${user.email}</td>
                                            <c:if test="${user.uid == 1}">
                                                <td class="text text-center" style="vertical-align: middle;">
                                                <span class="label label-primary">
                                                    超级管理员
                                                </span>
                                                </td>
                                            </c:if>
                                            <c:if test="${user.uid != 1}">
                                                <td class="text text-center" style="vertical-align: middle;">
                                                <span class="label label-success">
                                                    普通管理员
                                                </span>
                                                </td>
                                            </c:if>
                                            <td class="text text-center" style="vertical-align: middle;">
                                                <button type="submit" class="label label-primary">
                                                    修改信息
                                                </button>
                                            </td>
                                        </tr>
                                    </form>
                                </c:forEach>
                                </tbody>
                            </table>
                            <p class="text">共${fn:length(requestScope.usersList)}条记录</p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <%@include file="common.jsp"%>
        </section>
    </div>
</div>
</body>
</html>