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
                <li class="active">
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
                    <li class="treeview">
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
                            <li>
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
        <section class="page-body">
            <div class="row">
                <div class="fettle login">
                    <h1 class="title">
                        登录信息
                    </h1>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <tbody>
                            <tr>
                                <td>
                                    登录时间：<span>${sessionScope.loginTime}</span>
                                </td>
                                <td>
                                    登录IP：<span>${sessionScope.ip}</span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="fettle system">
                    <h1>管理员信息</h1>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <tbody>
                            <tr>
                                <td>管理员编号：</td>
                                <td>${sessionScope.user.uid}</td>
                                <td>管理员用户名：</td>
                                <td>${sessionScope.user.username}</td>
                            </tr>
                            <tr>
                                <td>真实姓名：</td>
                                <td>${sessionScope.user.realName}</td>
                                <td>电话号码：</td>
                                <td>${sessionScope.user.phone}</td>
                            </tr>
                            <tr>
                                <td>电子邮箱：</td>
                                <td>${sessionScope.user.email}</td>
                                <td>管理员权限：</td>
                                <td>${sessionScope.identity}</td>
                            </tr>
                            <tr>
                                <td>当前操作者:</td>
                                <td>${sessionScope.user.username}</td>
                                <td>当前IP:</td>
                                <td>${sessionScope.ip}</td>
                            </tr>
                            <tr>
                                <td>当前版本:</td>
                                <td>餐饮后台管理系统 v1.0(20211114)</td>
                                <td>当前时间:</td>
                                <td>${sessionScope.loginTime}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="fettle row widget">
                <h1 class="title">功能模块</h1>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-lightskyblue">
                            <i class="iconfont icon-search"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-lightskyblue">查询餐饮商品</h1>
                            <a class="more" href="${path}foodsServlet?action=selectAllFoods" title="查询餐饮商品">查询餐饮商品</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-green">
                            <i class="iconfont icon-pencil"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-green">修改餐饮商品</h1>
                            <a class="more" href="${path}foodsServlet?action=modifyList" title="修改餐饮商品">修改餐饮商品</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-yellow">
                            <i class="iconfont icon-remove"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-yellow">删除餐饮商品</h1>
                            <a class="more" href="${path}foodsServlet?action=deleteFoodsList" title="删除餐饮商品">
                                删除餐饮商品
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-green">
                            <i class="iconfont icon-plus"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-green">添加餐饮商品</h1>
                            <a class="more" href="${path}pages/add.jsp" title="添加餐饮商品">
                                添加餐饮商品
                            </a>
                        </div>
                    </div>
                </div>
            </div>
           <%@include file="common.jsp"%>
        </section>
    </div>
</div>
</body>
</html>