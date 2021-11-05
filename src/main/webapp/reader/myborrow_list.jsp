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
        <th>书籍编号</th>
        <th>书籍</th>
        <th>书籍封面</th>
        <th>预计归还日期</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${readerborrowBookInfos}" var="myborrowinfo">
        <tr>
            <td>${myborrowinfo.bookisbn}</td>
            <td>${myborrowinfo.bookname}</td>
            <td><img src="${myborrowinfo.picture}" class="order-picture"></td>
            <td>${myborrowinfo.backtime}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

