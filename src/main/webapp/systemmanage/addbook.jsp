<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="system" method="post" enctype="multipart/form-data">
   <div class="ui grid">

      <!-- 书记详情 -->
      <div class="five wide column stackable grid border-right">
         <div class="ui link cards width-915">
            <!-- 书籍缩略图 -->
            <div class="card">
               <div class="image">
                  <img id="preview">
               </div>
            </div>
         </div>
         <input id="file_upload" type="file" />
      </div>
      <!-- 书记详情 -->
      <div class="eleven wide column">
         <div class="ui container background-color-lightgray border-radius-5">
            <div class="margin-15px">
               <!-- 姓名 -->
               <div class="ui right labeled input margin-top-10 margin-left-10">
                  <div class="ui label">书名：</div>
                  <input type="text" placeholder="请输入您的名字...">
               </div>

               <br>
               <!-- 身份证号码 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">读者姓名： </div>
                  <input type="password" placeholder="请输入您的姓名...">
               </div>
               <br>
               <!-- 借书时间 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">身份证号：</div>
                  <input type="password" placeholder="请输入您的身份证号...">
               </div>
               <br>
               <!-- 借书时间 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">书籍信息：</div>
                  <input type="password" placeholder="请输入书籍状态...">
               </div>
               <br>
            </div>
         </div>

         <button class="ui primary button margin-top-10 margin-left-20 margin-bottom-20">
            确认还书
         </button>
         <button class="ui  button margin-top-10 margin-left-20 margin-bottom-20">
            返回
         </button>
      </div>
   </div>
</form>

<div class="ui grid">

   <form action="system" method="post" enctype="multipart/form-data">
      <%--    判断用户行为，告诉servlet这里要注册  --%>
      <input type="hidden" name="actionName" value="addbook">
      名称:<input type="text" name="uname"><br>
      文件:<input type="file" name="myfile"><br>
      <input type="submit" value="上传">
   </form>
</div>