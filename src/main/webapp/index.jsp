<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
            <div class="column"><a href="bookstype?actionName=bookslist"><img class="menu-logo"
                                                                              src="./statics/images/logo.png"
                                                                              alt="logo"></a></div>
            <div class="column right floated login-info">

                <c:if test="${loginFleid == null}">
                    <a class="margin-right-10" href="login?actionName=loginIndex">登录</a>
                    <a href="login?actionName=register">注册</a>
                </c:if>

                <c:if test="${loginFleid == 'reader'}">
                    <span>${resultInfo.result.reader_name}</span>&nbsp&nbsp
                    <a href="#">退出</a>
                </c:if>

                <c:if test="${loginFleid == 'librarymanage'}">
                    <span> ${resultInfo.result.librarymanage_name}</span>&nbsp&nbsp
                    <a href="#">退出</a>
                </c:if>

                <c:if test="${loginFleid == 'systemmanage'}">
                    <span> ${resultInfo.result.systemmanage_name}</span> &nbsp&nbsp
                    <a href="#">退出</a>
                </c:if>

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
        <div class="item"><a href="bookstype?actionName=bookslist">首页</a></div>
        <%--    未登录时的导航菜单    --%>
        <c:if test="${loginFleid == null}">

        </c:if>
        <%--读者导航菜单--%>
        <c:if test="${loginFleid == 'reader'}">
            <div class="item"><a href="#">我的预约</a></div>
            <div class="item"><a href="#">借书信息</a></div>
        </c:if>
        <%--图书管理员导航菜单管理--%>
        <c:if test="${loginFleid == 'librarymanage'}">
            <div class="item"><a href="#">预约管理</a></div>
            <div class="item"><a href="#">读者管理</a></div>
        </c:if>

        <%--系统管理员导航菜单--%>
        <c:if test="${loginFleid == 'systemmanage'}">
            <div class="item"><a href="#">添加书籍</a></div>
            <div class="item"><a href="#">图书管理员列表</a></div>
        </c:if>

        <div class="right menu borderless">
            <form action="index" method="post">
                <div class="item borderless">
                    <div class="ui action left icon input">
                        <i class="search icon"></i>
                        <input type="hidden" name="actionName" value="search">
                        <input type="text" placeholder="搜索" name="searchValue">
                        <button class="ui button" type="submit">搜索</button>
                    </div>
                </div>
            </form>
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
    ${changePage}
    版权所有归图书馆所有
</div>

<!-- semantic ui js资源 -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>

</html>
