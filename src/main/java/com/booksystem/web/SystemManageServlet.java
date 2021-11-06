package com.booksystem.web;

import com.booksystem.dao.BooksInfoDao;
import com.booksystem.po.BooksInfo;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/system")
public class SystemManageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断用户行为并执行指定函数
        String actionName = request.getParameter("actionName");
        if ("addbookpage".equals(actionName)) {
            //用户登录，向userLogin（）方法中传递登录页面中发送的请求req和响应res
            //表单的提交都是通过request和response进行传递的，所以思考思考
            AddBookPage(request, response);
        } else {

            //创建上传对象
            SmartUpload smartUpload = new SmartUpload();
            //初始化
            smartUpload.initialize(this.getServletConfig(), request, response);
            //设置编码

            //4.上传
            try {
                smartUpload.upload();
            } catch (SmartUploadException e) {
                e.printStackTrace();
            }
            //5.保存文件
            File file = smartUpload.getFiles().getFile(0);
            //6.得到文件的基本信息
            String fileName = file.getFileName();
//            String test = smartUpload.getRequest().getParameter("uname");//乱码
            //编码转码
            String mymane = new String(smartUpload.getRequest().getParameter("uname").getBytes(),"utf-8");
            //指定服务器保存文件的路径
            String url = "F:\\LibrarySystem\\BookSystem\\src\\main\\webapp\\statics\\images";
            //保存文件
            try {
                smartUpload.save(url);
            } catch (SmartUploadException e) {
                e.printStackTrace();
            }

            request.setAttribute("changePage", "books/books_list.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }


    private void AddBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("changePage", "systemmanage/addbook.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
