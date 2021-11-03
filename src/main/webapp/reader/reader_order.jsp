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
        <th>书名</th>
        <th>作者</th>
        <th>封面</th>
        <th>书籍状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${OrderInfoList}" var="orderinfo">
        <tr>
            <td>${orderinfo.bookname}</td>
            <td>${orderinfo.author}</td>
            <td><img src="${orderinfo.picture}" class="order-picture"></td>
            <td>${orderinfo.orderstatus}</td>
            <td>
                <a href="reader?actionName=deleteOrder&orderBookName=${orderinfo.bookname}" class="ui primary button margin-top-10 margin-left-20 margin-bottom-20">
                    取消预定
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

