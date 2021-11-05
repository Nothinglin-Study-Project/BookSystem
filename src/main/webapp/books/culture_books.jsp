<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui grid">
    <!-- 书籍导航菜单 -->
    <div class="three wide column stackable grid border-right">
        <div class="column margin-bottom-10">
            <a href="bookstype?actionName=bookslist" class="ui <c:if test="${menu_type=='index'}">blue</c:if> button item width-185">
                全部书籍(221)
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="bookstype?actionName=computerType" class="ui <c:if test="${menu_type=='computer'}">blue</c:if> button item width-185">
                计算机类（112）
            </a>
        </div>
        <div class="column margin-bottom-10">
            <a href="bookstype?actionName=cultureType" class="ui <c:if test="${menu_type=='culture'}">blue</c:if> button item width-185">
                文学类（100）
            </a>
        </div>
    </div>
    <!-- 书籍显示列表 -->
    <div class="eleven wide column">
        <div class="ui link cards width-915">
            <c:forEach items="${CultureBooks}" var="books">
                <!-- 一个书籍列表 -->
                <div class="card">
                    <div class="image">
                        <img src="${books.books_picture}">
                    </div>
                    <div class="content">
                        <div class="header"><a href="detail?actionName=bookdetail&bookisbn=${books.books_isbn}">${books.books_name}</a></div>
                        <div class="description">
                            作者：${books.books_author}
                        </div>
                        <div class="description">
                            ISBN：${books.books_isbn}
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

</div>
