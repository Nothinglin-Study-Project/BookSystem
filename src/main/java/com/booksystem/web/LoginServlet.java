package com.booksystem.web;


import com.booksystem.dao.BaseDao;
import com.booksystem.po.LibraryManageInfo;
import com.booksystem.po.ReaderInfo;
import com.booksystem.service.LoginService;
import com.booksystem.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        }else if ("confirmRegister".equals(actionName)){
            ConfirmRegister(request,response);
        }else if ("readerLogin".equals(actionName)){
            ReaderLogin(request,response);
        }else if ("bookManegeLogin".equals(actionName)){
            BookManegeLogin(request,response);
        }

    }

    private void BookManegeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取读者登录输入的账号和密码信息
        String bookManegeName = request.getParameter("bookManegeName");
        String bookManegePassword = request.getParameter("bookManegePassword");

        //调用service层的方法对登录信息进行校验，返回对应的校验结果给resultInfo对象
        LoginService loginService = new LoginService();
        ResultInfo<LibraryManageInfo> resultInfo = loginService.bookManageLogin(bookManegeName,bookManegePassword);

        //判断用户是否登陆成功
        if (resultInfo.getCode() == 1){
            request.setAttribute("changePage","page/librarymanage_page.jsp");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            //如果登录失败就要向前端返回msg提示
            request.setAttribute("resultInfo",resultInfo);
            request.setAttribute("changePage","login/librarymanage_login.jsp");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }

    private void ReaderLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取读者登录输入的账号和密码信息
        String readerName = request.getParameter("readerName");
        String readerPassword = request.getParameter("readerPassword");

        //调用service层的方法对登录信息进行校验，返回对应的校验结果给resultInfo对象
        LoginService loginService = new LoginService();
        ResultInfo<ReaderInfo> resultInfo = loginService.readerLogin(readerName,readerPassword);

        //判断用户是否登陆成功
        if (resultInfo.getCode() == 1){
            request.setAttribute("changePage","page/reader_page.jsp");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            //如果登录失败就要向前端返回msg提示
            request.setAttribute("resultInfo",resultInfo);
            request.setAttribute("changePage","login/reader_login.jsp");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

    private void ConfirmRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取输入框中的值
        String readerName = request.getParameter("readerName");
        String readerPassword = request.getParameter("readerPassword");
        String readerId = request.getParameter("readerId");
        String readerNumber = request.getParameter("readerNumber");

        //将参数放在一个数组中
        List<Object> params = new ArrayList<Object>();
        params.add(readerId);
        params.add(readerName);
        params.add(readerPassword);
        params.add(readerNumber);
        params.add("可借书");

        //定义数据查询语句
        String sql = "insert into reader_info(reader_id , reader_name , reader_password , reader_number , reader_status) values (?,?,?,?,?)";

        //调用basedao数据库更新方法插入数据

        BaseDao.executeUpdate(sql,params);

        request.setAttribute("changePage","login/reader_login.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);

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
