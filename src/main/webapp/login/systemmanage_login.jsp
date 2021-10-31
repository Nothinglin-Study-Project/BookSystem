<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui grid">
    <!-- 登录身份菜单 -->
    <div class="three wide column stackable grid border-right">
        <div class="column margin-bottom-10">
            <a href="login?actionName=loginIndex" class="ui button item width-185">
                读者登录
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="login?actionName=librarymanageLogin" class="ui button item width-185">
                图书管理员登录
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="login?actionName=systemmangeLogin" class="ui blue button item width-185">
                系统管理员登录
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="login?actionName=register" class="ui button item width-185">
                读者账号注册
            </a>
        </div>
    </div>
    <!-- 登录表 -->
    <div class="eleven wide column">
        <div class="ui container background-color-lightgray border-radius-5">
            <!-- 账号 -->
            <div class="ui right labeled input margin-top-10 margin-left-10">
                <div class="ui label"><i class="user icon"></i></div>
                <input type="text" placeholder="请输入账号...">
            </div>

            <br>
            <!-- 密码 -->
            <div class="ui right labeled input margin-top-10  margin-left-10">
                <div class="ui label"><i class="lock icon"></i></div>
                <input type="password" placeholder="请输入密码...">
            </div>
            <br>
            <button class="ui primary button margin-top-10 margin-left-20 margin-bottom-20">
                登录
            </button>
        </div>
    </div>

</div>