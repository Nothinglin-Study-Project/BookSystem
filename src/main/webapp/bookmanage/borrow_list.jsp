<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/11/3
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="ui celled table">
    <thead>
    <tr>
        <th>读者</th>
        <th>书籍</th>
        <th>书籍ISBN</th>
        <th>封面</th>
        <th>书籍状态</th>
        <th>读者身份证号码</th>
        <th>读者电话号码</th>
        <th>预计归还时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${borrowbookinfo}" var="borrowinfo">
        <tr>
            <td>${borrowinfo.readername}</td>
            <td>${borrowinfo.bookname}</td>
            <td>${borrowinfo.bookisbn}</td>
            <td><img src="${borrowinfo.picture}" class="order-picture"></td>
            <td>${borrowinfo.bookstatus}</td>
            <td>${borrowinfo.readerid}</td>
            <td>${borrowinfo.readernumber}</td>
            <td>${borrowinfo.backtime}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

