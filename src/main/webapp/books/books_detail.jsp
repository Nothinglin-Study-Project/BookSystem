<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 11:15
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
                    <img src="${findBookInfo.books_picture}">
                </div>
            </div>
        </div>
    </div>
    <!-- 书记详情 -->
    <div class="eleven wide column">
        <div class="ui container background-color-lightgray border-radius-5">
            <div class="margin-15px">
                <h4>书名：${findBookInfo.books_name}</h4>
                <h4>作者：${findBookInfo.books_author}</h4>
                <h4>状态：${findBookInfo.books_status}</h4>
                <h4>位置：${findBookInfo.books_position}</h4>
                <h4>简介：<br><br>${findBookInfo.books_intro}</h4>
            </div>
        </div>

        <c:if test="${WhoIsYou == 'reader' && findBookInfo.books_status=='在馆未借'}">
            <a href="reader?actionName=orderBook&orderBookName=${findBookInfo.books_name}&orderReaderName=${MyName.result.reader_name}"
               class="ui primary button margin-top-10 margin-left-20 margin-bottom-20">
                预约
            </a>
        </c:if>
        <a href="bookstype?actionName=bookslist" class="ui  button margin-top-10 margin-left-20 margin-bottom-20">
            返回
        </a>
    </div>

</div>