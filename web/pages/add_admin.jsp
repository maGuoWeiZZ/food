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
                            <li class="active">
                                <a href="${path}userServlet?action=addUserList">
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
            <div class="row widget">
                <section class="col-md-12 col-sm-12 col-xs-12">
                    <div class="box form">
                        <div class="box-header">
                            <h3 class="box-title">添加管理员</h3>
                        </div>
                        <div class="box-body">
                            <form name="form1" action="${path}userServlet?action=addUser"
                                  onsubmit="return checkAdmin()" method="post">
                                <div class="form-group">
                                    <label id="msg" class="label label-danger"></label>
                                </div>
                                <div class="form-group">
                                    <label>用户名</label>
                                    <input type="text" class="form-control" name="username" id="username"
                                           placeholder="请输入管理员用户名" onblur="checkName()">
                                    <label id="nameMsg" class="label"></label>
                                </div>
                                <div class="form-group">
                                    <label>密码</label>
                                    <input type="password" class="form-control" name="password" id="password"
                                           placeholder="请输入密码">
                                </div>
                                <div class="form-group">
                                    <label>确认密码</label>
                                    <input type="password" class="form-control" name="rePassword" id="rePassword"
                                           placeholder="请输入确认密码">
                                </div>
                                <div class="form-group">
                                    <label>真实姓名</label>
                                    <input type="text" class="form-control" name="realName" id="realName"
                                           placeholder="请输入真实姓名">
                                </div>
                                <div class="form-group">
                                    <label>电话号码</label>
                                    <input type="text" class="form-control" name="phone" id="phone"
                                           placeholder="请输入电话号码">
                                </div>
                                <div class="form-group">
                                    <label>电子邮箱</label>
                                    <input type="text" class="form-control" name="email" id="email"
                                           placeholder="请输入电子邮箱">
                                </div>
                                <button id="add" type="submit" class="btn btn-primary">添加</button>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
            <%--添加管理员表单输入验证--%>
            <script type="text/javascript">
                function checkName() {
                    $.ajax({
                        url: '${path}userServlet?action=checkUsername',
                        type: 'POST',
                        data: {
                            username: $('#username').val()
                        },
                        success: function (data) {
                            if (data == 'true') {
                                if ($('#username').val() != '') {
                                    $('#nameMsg').removeClass('label-danger');
                                    $('#nameMsg').addClass('label-success');
                                    $('#nameMsg').html('用户名可用');
                                    $('#add').attr('disabled',false);
                                }
                            } else {
                                $('#nameMsg').removeClass('label-success');
                                $('#nameMsg').addClass('label-danger');
                                $('#nameMsg').html('用户名已被占用');
                                $('#add').attr('disabled',true);
                            }
                        }
                    });
                }

                function checkAdmin() {
                    //电子邮箱正则验证
                    var regEmail = /^[A-Za-zd0-9]+([-_.][A-Za-zd]+)*@([A-Za-z0-9]+[-.])+[A-Za-zd]{2,5}$/;
                    //手机号码正则验证
                    var regPhone = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
                    //真是姓名验证
                    var regRealName = /^[a-zA-Z\u4e00-\u9fa5]+$/;
                    if (form1.username.value == '' || form1.username.value == null) {
                        $('#msg').html('管理员用户名不能为空！');
                        return false;
                    } else if (form1.password.value == '' || form1.password.value == null) {
                        $('#msg').html('密码不能为空！');
                        return false;
                    } else if (form1.password.value != form1.rePassword.value) {
                        $('#msg').html('确认密码不一致！');
                        return false;
                    } else if (form1.realName.value == '' || form1.realName.value == null) {
                        $('#msg').html('真实姓名不能为空！');
                        return false;
                    }else if (!(regRealName.test(form1.realName.value))) {
                        $('#msg').html('真实姓名格式不正确！');
                        return false;
                    } else if (form1.phone.value == '' || form1.phone.value == null) {
                        $('#msg').html('手机号码不能为空！');
                        return false;
                    } else if (!(regPhone.test(form1.phone.value))) {
                        $('#msg').html('手机号码格式不正确！');
                        return false;
                    } else if (form1.email.value == '' || form1.email.value == null) {
                        $('#msg').html('电子邮箱不能为空！');
                        return false;
                    } else if (!(regEmail.test(form1.email.value))) {
                        $('#msg').html('电子邮箱格式不正确！');
                        return false;
                    } else {
                        $('#msg').html('');
                        return true;
                    }
                }
            </script>
            <%@include file="common.jsp" %>
        </section>
    </div>
</div>
</body>
</html>