package com.booksystem.web;

import com.booksystem.dao.BaseDao;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/system")
public class SystemManageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
            //6.得到图片名
            String pictureName =new String(file.getFileName().getBytes(),"UTF-8");
            //String test = smartUpload.getRequest().getParameter("uname");//乱码
            //正确编码转码
            //String mymane = new String(smartUpload.getRequest().getParameter("uname").getBytes(),"utf-8");
            //指定服务器保存文件的路径
            String url = "F:\\LibrarySystem\\BookSystem\\src\\main\\webapp\\statics\\images";
            //保存文件
            try {
                smartUpload.save(url);
            } catch (SmartUploadException e) {
                e.printStackTrace();
            }

            //获取输入的isbn
            String books_isbn = new String(smartUpload.getRequest().getParameter("books_isbn").getBytes(),"UTF-8");
            //获取输入的书名
            String books_name = new String(smartUpload.getRequest().getParameter("books_name").getBytes(),"UTF-8");
            //获取输入的作者
            String books_author = new String(smartUpload.getRequest().getParameter("books_author").getBytes(),"UTF-8");
            //获取输入的简介
            String books_intro = new String(smartUpload.getRequest().getParameter("books_intro").getBytes(),"UTF-8");
            //获取输入的位置
            String books_position = new String(smartUpload.getRequest().getParameter("books_position").getBytes(),"UTF-8");
            //获取输入的书籍状态
            String books_status = new String(smartUpload.getRequest().getParameter("books_status").getBytes(),"UTF-8");
            //获取输入的书籍类型
            String books_type = new String(smartUpload.getRequest().getParameter("books_type").getBytes(),"UTF-8");


            //定义sql语句，把输入的信息插入到数据库中
            String sql = "insert into books_info(books_isbn , books_name , books_author , books_intro , books_position , books_status , books_type , books_picture) values (?,?,?,?,?,?,?,?)";
            //将参数放在一个数组中
            List<Object> params = new ArrayList<Object>();
            params.add(books_isbn);
            params.add(books_name);
            params.add(books_author);
            params.add(books_intro);
            params.add(books_position);
            params.add(books_status);
            params.add(books_type);
            params.add("./statics/images/"+pictureName);

            //调用basedao数据库更新方法插入数据
            BaseDao.executeUpdate(sql,params);

            request.setAttribute("changePage", "systemmanage/addbook.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }


    private void AddBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("changePage", "systemmanage/addbook.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
