package com.booksystem.web;

import com.booksystem.dao.BooksInfoDao;
import com.booksystem.po.BooksInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //图书列表展示
        bookslist(request,response);

        //页面跳转
        //1.设置首页动态包含的页面值
        request.setAttribute("changePage","books/books_list.jsp");
        //2.请求转发跳转到index
        //设置导航页面为http://localhost:8080/BookSystem_war_exploded/index ---> 指向index.jsp页面
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    private void bookslist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BooksInfo> booksInfo = BooksInfoDao.findAll();
        request.setAttribute("booksInfo",booksInfo);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
