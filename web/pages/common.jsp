<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 修改密码模态框 -->
<div class="modal fade menu-setpassword" tabindex="-1" role="dialog">
    <form name="formPwd" action="${path}userServlet?action=modifyPwd"
          onsubmit="return check()"
          method="post">
        <input type="hidden" name="uid" value="${sessionScope.user.uid}">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">修改密码</h4>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <%--确认密码提示信息--%>
                            <td id="pwd_msg" colspan="2" class="label label-danger"></td>
                        </tr>
                        <tr>
                            <th>
                                新密码
                            </th>
                            <td>
                                <input type="password" class="form-control" placeholder="请输入新密码"
                                       name="newPassword">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                确认密码
                            </th>
                            <td>
                                <input type="password" class="form-control" placeholder="请再次输入新密码"
                                       name="verifyPassword">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </form>
</div>
<%--密码验证--%>
<script type="text/javascript">
    function check() {
        var td = document.getElementById("pwd_msg");
        if (formPwd.newPassword.value == '' || formPwd.verifyPassword.value == '') {
            td.innerText = "密码不能为空";
            return false;
        } else if (formPwd.newPassword.value != formPwd.verifyPassword.value) {
            td.innerText = "两次输入密码不一致";
            return false;
        } else {
            td.innerText = "";
            return true;
        }
    }
</script>
<%--按名称查询餐饮商品模态框--%>
<div class="modal fade menu-select" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入餐饮商品名称</h4>
            </div>
            <form action="${path}foodsServlet?action=selectFoodsByName"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                餐饮商品名称
                            </th>
                            <td>
                                <input type="text" class="form-control" placeholder="请输入餐饮商品名称"
                                       name="name">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">查询</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 退出提示模态框 -->
<div class="modal fade menu-logout" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p>是否确定退出</p>
            </div>
            <div class="modal-footer">
                <form action="${path}userServlet" method="post">
                    <input type="hidden" name="action" value="logout">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">登出</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${path}assets/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${path}assets/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${path}assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}assets/libs/tinymce/tinymce.min.js"></script>
<script type="text/javascript" src="${path}assets/js/Chart.min.js"></script>
<script type="text/javascript" src="${path}assets/js/echarts.min.js"></script>
<script type="text/javascript" src="${path}assets/js/alpha.js"></script>
<script type="text/javascript" src="${path}assets/js/dashboard.js"></script>
</body>

</html>
