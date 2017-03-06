<%--
  Created by IntelliJ IDEA.
  User: zxk175
  Date: 16/11/13
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <!-- bootstrap -->
    <link rel="stylesheet" type="text/css" href="${ctx}/library/bootstrap/css/bootstrap.min.css"/>
    <%-- base --%>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/base.css"/>
</head>
<a href="user/show" target="_blank" class="link">查看所有用户</a>

<a href="ex?id=10" target="_blank" class="link">测试业务异常</a>

<a href="ex?id=20" target="_blank" class="link">测试参数异常</a>

<a href="ex?id=" target="_blank" class="link">测试通用异常</a>

<a href="task/show" target="_blank" class="link">查看所有任务</a>

<a href="swagger-ui.html" target="_blank" class="link">项目API管理</a>
</body>
</html>
