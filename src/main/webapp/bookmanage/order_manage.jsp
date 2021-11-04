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
        <th>ISBN</th>
        <th>读者</th>
        <th>读者状态</th>
        <th>读者身份证号码</th>
        <th>书名</th>
        <th>作者</th>
        <th>封面</th>
        <th>预定状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${OrderInfoList}" var="orderinfo">
        <tr>
            <td>${orderinfo.bookisbn}</td>
            <td>${orderinfo.readername}</td>
            <td>${orderinfo.readerstatus}</td>
            <td>${orderinfo.readerid}</td>
            <td>${orderinfo.bookname}</td>
            <td>${orderinfo.author}</td>
            <td><img src="${orderinfo.picture}" class="order-picture"></td>
            <td>${orderinfo.orderstatus}</td>
            <td>
                <c:if test="${orderinfo.orderstatus == '未审核'}">
                <a href="bookmanage?actionName=agreeorder&bookisbn=${orderinfo.bookisbn}" class="ui primary button margin-top-10 margin-left-20 margin-bottom-20">
                    同意
                </a>

                <a href="bookmanage?actionName=disagreeorder&bookisbn=${orderinfo.bookisbn}" class="ui red button margin-top-10 margin-left-20 margin-bottom-20">
                    不同意
                </a>
                </c:if>

                <c:if test="${orderinfo.orderstatus == '已审核'}">
                    已通过审核！！
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

