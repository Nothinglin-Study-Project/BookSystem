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

@WebServlet("/bookstype")
public class BooksTypeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断用户行为并执行指定函数
        String actionName = request.getParameter("actionName");
        if ("computerType".equals(actionName)) {
            computerBooks(request, response);

        }else if ("cultureType".equals(actionName)) {
            cultureType(request, response);

        }

    }

    private void cultureType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置首页动态包含的页面值
        request.setAttribute("changePage", "books/culture_books.jsp");
        List<BooksInfo> CultureBooks = BooksInfoDao.findComputerBooks("文学类");
        request.setAttribute("CultureBooks", CultureBooks);
        request.setAttribute("menu_type","culture");
        //页面跳转
        //2.请求转发跳转到index
        //设置导航页面为http://localhost:8080/BookSystem_war_exploded/index ---> 指向index.jsp页面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void computerBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置首页动态包含的页面值
        request.setAttribute("changePage", "books/computer_books.jsp");
        List<BooksInfo> ComputerBooks = BooksInfoDao.findComputerBooks("计算机类");
        request.setAttribute("ComputerBooks", ComputerBooks);
        request.setAttribute("menu_type","computer");
        //页面跳转
        //2.请求转发跳转到index
        //设置导航页面为http://localhost:8080/BookSystem_war_exploded/index ---> 指向index.jsp页面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
