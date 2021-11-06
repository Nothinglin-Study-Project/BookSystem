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
         <input id="file_upload" type="file" name="file"/>
      </div>
      <!-- 书记详情 -->
      <div class="eleven wide column">
         <div class="ui container background-color-lightgray border-radius-5">
            <div class="margin-15px">
               <!-- ISBN -->
               <div class="ui right labeled input margin-top-10 margin-left-10">
                  <div class="ui label">ISBN：</div>
                  <input type="text" placeholder="请输入书籍ISBN..." name="books_isbn">
               </div>

               <br>
               <!-- 书名 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">书名： </div>
                  <input type="text" placeholder="请输入书名..." name="books_name">
               </div>
               <br>
               <!-- 书籍作者 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">书籍作者：</div>
                  <input type="text" placeholder="请输入书籍作者..." name="books_author">
               </div>
               <br>
               <!-- 书籍简介 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">书籍简介：</div>
                  <input type="text" placeholder="请输入书籍简介..." name="books_intro">
               </div>
               <br>
               <!-- 书籍位置 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">书籍位置：</div>
                  <input type="text" placeholder="请输入书籍位置..." name="books_position">
               </div>
               <br>
               <!-- 书籍状态 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">书籍状态：</div>
                  <input type="text" placeholder="请输入书籍状态..." name="books_status">
               </div>
               <br>
               <!-- 书籍类型 -->
               <div class="ui right labeled input margin-top-10  margin-left-10">
                  <div class="ui label">书籍类型：</div>
                  <input type="text" placeholder="请输入书籍类型..." name="books_type">
               </div>
               <br>
            </div>
         </div>

         <button class="ui primary button margin-top-10 margin-left-20 margin-bottom-20" type="submit">
            确认添加
         </button>
         <button class="ui  button margin-top-10 margin-left-20 margin-bottom-20">
            返回
         </button>
      </div>
   </div>
</form>