<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="./statics/css/customCss.css">
</head>

<body>
<!-- 导航栏部分 -->
<div class="ui segment attached">
    <div class="ui container">
        <div class="ui grid">
            <div class="column"><a href="index?actionName=bookslist"><img class="menu-logo" src="./statics/images/logo.png" alt="logo"></a></div>
            <div class="column right floated login-info">
                <a class="margin-right-10" href="login?actionName=loginIndex">登录</a>
                <a href="login?actionName=register">注册</a>
            </div>
        </div>
    </div>

</div>
<!-- 背景图片 -->
<div class="ui container background-pic">
    <img src="./statics/images/background.png" alt="background" class="background-position">
</div>
<!-- 菜单栏部分 -->
<div class="ui container">
    <div class="ui menu">
        <div class="item"><a href="index?actionName=bookslist">首页</a></div>
        <div class="item"><a href="#">我的预约</a></div>
        <div class="item"><a href="#">借书信息</a></div>
        <div class="right menu">
            <div class="item borderless">
                <div class="ui action left icon input">
                    <i class="search icon"></i>
                    <input type="text" placeholder="搜索">
                    <button class="ui button">搜索</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="ui container margin-top-50">
    <div class="ui segment">
<%--        &lt;%&ndash; 如果changPage没有值就默认显示list页面&ndash;%&gt;--%>
        <c:if test="${empty changePage}">
            <jsp:include page="books/books_list.jsp"></jsp:include>
        </c:if>
        <%-- 如果对应的changePage不为空，则请求跳转到对应页面--%>
        <c:if test="${!empty changePage}">
            <jsp:include page="${changePage}"></jsp:include>
        </c:if>
    </div>

</div>


<div class="ui segment attached margin-top-50">

    版权所有归图书馆所有
</div>

<!-- semantic ui js资源 -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>

</html>
