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

        //判断用户行为并执行指定函数
        String actionName = request.getParameter("actionName");
        if ("bookslist".equals(actionName)) {
            //用户登录，向userLogin（）方法中传递登录页面中发送的请求req和响应res
            //表单的提交都是通过request和response进行传递的，所以思考思考
            bookslist(request, response);
        } else if ("computerType".equals(actionName)) {
            //1.设置首页动态包含的页面值
            request.setAttribute("changePage", "books/computer_books.jsp");
            computerBooks(request, response);
        } else if ("search".equals(actionName)){
            SearchBook(request, response);
        }

        //图书列表展示
        bookslist(request, response);

    }

    private void SearchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String SearchValue = request.getParameter("searchValue");
        List<BooksInfo> SearchBooks = BooksInfoDao.SearchBookByName(SearchValue);
        request.setAttribute("SearchBooks", SearchBooks);
        request.setAttribute("changePage", "books/search_books.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void computerBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BooksInfo> ComputerBooks = BooksInfoDao.findComputerBooks("计算机类");
        request.setAttribute("ComputerBooks", ComputerBooks);
        request.getRequestDispatcher("books/computer_books.jsp").forward(request, response);

    }

    private void bookslist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BooksInfo> booksInfo = BooksInfoDao.findAll();
        request.setAttribute("booksInfo", booksInfo);
        request.setAttribute("menu_type","index");

        //页面跳转
        //2.请求转发跳转到index
        //设置导航页面为http://localhost:8080/BookSystem_war_exploded/index ---> 指向index.jsp页面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
