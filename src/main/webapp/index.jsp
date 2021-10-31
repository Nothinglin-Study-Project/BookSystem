<%--
  Created by IntelliJ IDEA.
  User: Nothing
  Date: 2021/10/31
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="./statics/css/customCss.css">
</head>

<body>
<!-- 导航栏部分 -->
<div class="ui segment attached">
    <div class="ui container">
        <div class="ui grid">
            <div class="column"><img class="menu-logo" src="./statics/images/logo.png" alt="logo"></div>
            <div class="column right floated login-info">
                <a class="margin-right-10" href="#">登录</a>
                <a href="#">注册</a>
            </div>
        </div>
    </div>

</div>
<!-- 背景图片 -->
<div class="ui container background-pic">
    <img src="./statics/images/background.png" alt="background" class="background-position">
</div>
<!-- 菜单栏部分 -->
<div class="ui container">
    <div class="ui menu">
        <div class="item"><a href="#">首页</a></div>
        <div class="item"><a href="#">我的预约</a></div>
        <div class="item"><a href="#">借书信息</a></div>
        <div class="right menu">
            <div class="item borderless">
                <div class="ui action left icon input">
                    <i class="search icon"></i>
                    <input type="text" placeholder="搜索">
                    <button class="ui button">搜索</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="ui container margin-top-50">
    <div class="ui segment">
        <div class="ui grid">
            <!-- 书籍导航菜单 -->
            <div class="three wide column stackable grid border-right">
                <div class="column margin-bottom-10">
                    <button class="ui blue button item width-185">
                        全部书籍（226）
                    </button>
                </div>
                <div class="column margin-bottom-10">
                    <button class="ui button item width-185">
                        计算机类（112）
                    </button>
                </div>
                <div class="column margin-bottom-10">
                    <button class="ui button item width-185">
                        文学类（100）
                    </button>
                </div>
            </div>
            <!-- 书籍显示列表 -->
            <div class="eleven wide column">
                <div class="ui link cards width-915">
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/java.png">
                        </div>
                        <div class="content">
                            <div class="header">Java语言程序设计</div>
                            <div class="description">
                                作者：张三
                            </div>
                            <div class="description">
                                ISBN：1101564
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/老人与海.png">
                        </div>
                        <div class="content">
                            <div class="header">老人与海</div>
                            <div class="description">
                                作者：海明威
                            </div>
                            <div class="description">
                                ISBN：1104698
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/mysql.png">
                        </div>
                        <div class="content">
                            <div class="header">Mysql修炼之道</div>
                            <div class="description">
                                作者：李四
                            </div>
                            <div class="description">
                                ISBN：5987451
                            </div>
                        </div>
                    </div>

                    <!-- 填充内容 -->
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/java.png">
                        </div>
                        <div class="content">
                            <div class="header">Java语言程序设计</div>
                            <div class="description">
                                作者：张三
                            </div>
                            <div class="description">
                                ISBN：1101564
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/老人与海.png">
                        </div>
                        <div class="content">
                            <div class="header">老人与海</div>
                            <div class="description">
                                作者：海明威
                            </div>
                            <div class="description">
                                ISBN：1104698
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/mysql.png">
                        </div>
                        <div class="content">
                            <div class="header">Mysql修炼之道</div>
                            <div class="description">
                                作者：李四
                            </div>
                            <div class="description">
                                ISBN：5987451
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/java.png">
                        </div>
                        <div class="content">
                            <div class="header">Java语言程序设计</div>
                            <div class="description">
                                作者：张三
                            </div>
                            <div class="description">
                                ISBN：1101564
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/老人与海.png">
                        </div>
                        <div class="content">
                            <div class="header">老人与海</div>
                            <div class="description">
                                作者：海明威
                            </div>
                            <div class="description">
                                ISBN：1104698
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/mysql.png">
                        </div>
                        <div class="content">
                            <div class="header">Mysql修炼之道</div>
                            <div class="description">
                                作者：李四
                            </div>
                            <div class="description">
                                ISBN：5987451
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/java.png">
                        </div>
                        <div class="content">
                            <div class="header">Java语言程序设计</div>
                            <div class="description">
                                作者：张三
                            </div>
                            <div class="description">
                                ISBN：1101564
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/老人与海.png">
                        </div>
                        <div class="content">
                            <div class="header">老人与海</div>
                            <div class="description">
                                作者：海明威
                            </div>
                            <div class="description">
                                ISBN：1104698
                            </div>
                        </div>
                    </div>
                    <!-- 一个书籍列表 -->
                    <div class="card">
                        <div class="image">
                            <img src="./statics/images/mysql.png">
                        </div>
                        <div class="content">
                            <div class="header">Mysql修炼之道</div>
                            <div class="description">
                                作者：李四
                            </div>
                            <div class="description">
                                ISBN：5987451
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>


<div class="ui segment attached margin-top-50">

    版权所有归图书馆所有
</div>

<!-- semantic ui js资源 -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>

</html>
