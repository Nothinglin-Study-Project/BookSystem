<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/11/3
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui grid">
    <!-- 书记详情 -->
    <div class="five wide column stackable grid border-right">
        <div class="ui link cards width-915">
            <!-- 书籍缩略图 -->
            <div class="card">
                <div class="image">
                    <img src="./statics/images/java.png">
                </div>
            </div>
        </div>
    </div>
    <!-- 书记详情 -->
    <div class="eleven wide column">
        <div class="ui container background-color-lightgray border-radius-5">
            <div class="margin-15px">
                <!-- 姓名 -->
                <div class="ui right labeled input margin-top-10 margin-left-10">
                    <div class="ui label">借书人姓名：</div>
                    <input type="text" placeholder="请输入您的名字...">
                </div>

                <br>
                <!-- 身份证号码 -->
                <div class="ui right labeled input margin-top-10  margin-left-10">
                    <div class="ui label">身份证号码： </div>
                    <input type="password" placeholder="请输入您的身份证号码...">
                </div>
                <br>
                <!-- 借书时间 -->
                <div class="ui right labeled input margin-top-10  margin-left-10">
                    <div class="ui label">预约借书时间：</div>
                    <input type="password" placeholder="请输入您的预约时间...">
                </div>

                <br>
            </div>
        </div>

        <button class="ui primary button margin-top-10 margin-left-20 margin-bottom-20">
            预约
        </button>
        <button class="ui  button margin-top-10 margin-left-20 margin-bottom-20">
            返回
        </button>
    </div>

</div>
