<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui grid">
    <!-- 登录身份菜单 -->
    <div class="three wide column stackable grid border-right">
        <div class="column margin-bottom-10">
            <a href="login?actionName=loginIndex" class="ui button item width-185">
                读者登录
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="login?actionName=librarymanageLogin" class="ui button item width-185" href="#">
                图书管理员登录
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="login?actionName=systemmangeLogin" class="ui button item width-185">
                系统管理员登录
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="login?actionName=register" class="ui blue button item width-185">
                读者账号注册
            </a>
        </div>
    </div>
    <!-- 登录表 -->
    <div class="eleven wide column">
        <div class="ui container background-color-lightgray border-radius-5">
            <form action="login" method="post">
                <%--    判断用户行为，告诉servlet这里要注册  --%>
                <input type="hidden" name="actionName" value="confirmRegister">
                <!-- 账号 -->
                <div class="ui right labeled input margin-top-10 margin-left-10">
                    <div class="ui label"><i class="user icon"></i></div>
                    <input type="text" placeholder="请输入账号..." name="readerName">
                </div>

                <br>
                <!-- 密码 -->
                <div class="ui right labeled input margin-top-10  margin-left-10">
                    <div class="ui label"><i class="lock icon"></i></div>
                    <input type="password" placeholder="请输入密码..." name="readerPassword">
                </div>

                <br>
                <!-- 输入身份证号 -->
                <div class="ui right labeled input margin-top-10  margin-left-10">
                    <div class="ui label"><i class="id badge icon"></i></div>
                    <input type="text" placeholder="请输入您的身份证号码..." name="readerId">
                </div>

                <br>
                <!-- 输入手机号 -->
                <div class="ui right labeled input margin-top-10  margin-left-10">
                    <div class="ui label"><i class="mobile alternate icon"></i></div>
                    <input type="text" placeholder="请输入您的手机号码..." name="readerNumber">
                </div>

                <br>
                <input class="ui primary button margin-top-10 margin-left-20 margin-bottom-20" type="submit" value="确认注册">

            </form>
        </div>
    </div>

</div>