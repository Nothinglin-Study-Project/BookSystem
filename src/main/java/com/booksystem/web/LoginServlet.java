package com.booksystem.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断用户行为并执行指定函数
        //获取用户行为，判断用户的行为操作
        String actionName = request.getParameter("actionName");
        if ("loginIndex".equals(actionName)){
            TurnToReaderLogin(request,response);
        }else if ("register".equals(actionName)){
            TurnToRegister(request,response);
        }else if ("librarymanageLogin".equals(actionName)){
            LibraryManageLogin(request,response);
        }else if ("systemmangeLogin".equals(actionName)){
            SystemMangeLogin(request,response);
        }

    }

    private void SystemMangeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置changepage值到reader_login页面
        request.setAttribute("changePage","login/systemmanage_login.jsp");
        //将设置结果返回给前端
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void LibraryManageLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置changepage值到reader_login页面
        request.setAttribute("changePage","login/librarymanage_login.jsp");
        //将设置结果返回给前端
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void TurnToRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置changepage值到reader_login页面
        request.setAttribute("changePage","login/reader_register.jsp");
        //将设置结果返回给前端
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void TurnToReaderLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置changepage值到reader_login页面
        request.setAttribute("changePage","login/reader_login.jsp");
        //将设置结果返回给前端
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
