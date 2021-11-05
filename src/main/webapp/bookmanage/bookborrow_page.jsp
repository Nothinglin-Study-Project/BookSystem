<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui container background-color-lightgray border-radius-5">
    <form action="bookmanage" method="post">
        <%--    判断用户行为，告诉servlet这里要注册  --%>
        <input type="hidden" name="actionName" value="borrowBook">
        <input type="hidden" name="infoBookisbn" value="${findBookInfo.books_isbn}">
        <input type="hidden" name="infoBookname" value="${findBookInfo.books_name}">
        <input type="hidden" name="infoBookpicture" value=${findBookInfo.books_picture}>
        <input type="hidden" name="infoBookstatus" value=${findBookInfo.books_status}>
        <!-- 读者姓名 -->
        <div class="ui right labeled input margin-top-10 margin-left-10">
            <div class="ui label">读者姓名：</div>
            <input type="text" name="readerName">
        </div>

        <br>
        <!-- 归还日期 -->
        <div class="ui right labeled input margin-top-10  margin-left-10">
            <div class="ui label">归还日期：</div>
            <input type="text" name="backTime">
        </div>

        <br>
        <!-- 读者身份证号码 -->
        <div class="ui right labeled input margin-top-10  margin-left-10">
            <div class="ui label">读者身份证号码：</div>
            <input type="text" name="readerId">
        </div>

        <br>
        <!-- 读者电话号码 -->
        <div class="ui right labeled input margin-top-10  margin-left-10">
            <div class="ui label">读者电话号码：</div>
            <input type="text" name="readerNumber">
        </div>

        <br>
        <button class="ui primary button margin-top-10 margin-left-20 margin-bottom-20" type="submit">确认</button>

    </form>
</div>
</div>