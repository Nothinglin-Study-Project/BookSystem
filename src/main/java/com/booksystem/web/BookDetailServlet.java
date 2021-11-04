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

@WebServlet("/detail")
public class BookDetailServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断用户行为并执行指定函数
        String actionName = request.getParameter("actionName");
        if ("bookdetail".equals(actionName)) {
            ToBookDetail(request, response);
        }

    }


    private void ToBookDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookisbn= request.getParameter("bookisbn");
        BooksInfo findBookInfo = BooksInfoDao.findBookByIsbn(bookisbn);
        request.setAttribute("findBookInfo",findBookInfo);
        //1.设置首页动态包含的页面值
        request.setAttribute("changePage","books/books_detail.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
