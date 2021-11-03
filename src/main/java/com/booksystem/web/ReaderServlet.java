package com.booksystem.web;


import com.booksystem.dao.BaseDao;
import com.booksystem.dao.BooksInfoDao;
import com.booksystem.po.BooksInfo;
import com.booksystem.po.OrderInfo;
import com.booksystem.po.ReaderInfo;
import com.booksystem.service.ReaderOrderService;
import com.booksystem.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/reader")
public class ReaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断用户行为并执行指定函数
        String actionName = request.getParameter("actionName");
        if ("myorder".equals(actionName)) {
            ToMyOrderPage(request, response);
        }else if ("orderBook".equals(actionName)){
            ReaderOrderBook(request, response);
        }else if ("deleteOrder".equals(actionName)){
            DeleteOrder(request, response);
        }

    }

    private void DeleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderBookName = request.getParameter("orderBookName");
        //1.销毁Session对象
        request.getSession().removeAttribute("OrderInfoList");


        //2.定义删除语句
        String sql = "delete from order_info where bookname = ?";
        List<Object> params = new ArrayList<>();
        params.add(orderBookName);
        BaseDao.executeUpdate(sql,params);

        //定义获取订单信息的sql语句
        String sql2 = "select * from order_info";

        //调用basedao方法查询表中的全部内容
        List<BooksInfo> OrderInfoList = BaseDao.findAll(sql2, OrderInfo.class);

        //更新session内容
        //向前端传递Orderinfo获得的内容
        request.getSession().setAttribute("OrderInfoList",OrderInfoList);


        request.setAttribute("changePage","reader/reader_order.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void ReaderOrderBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderBookName =request.getParameter("orderBookName");
        String orderReaderName = request.getParameter("orderReaderName");
        ReaderOrderService readerOrderService = new ReaderOrderService();

        ReaderInfo queryreaderInfo = readerOrderService.CheckReaderInfo(orderReaderName);
        BooksInfo queryBookInfo = readerOrderService.CheckBookInfo(orderBookName);

        //定义向订单表中插入预定信息的sql语句
        String sql = "insert into order_info(bookname , author , picture , backtime , orderstatus , readername , readerid) values(?,?,?,?,?,?,?)";

        //定义一个参数数组
        List<Object> params = new ArrayList<>();
        params.add(queryBookInfo.getBooks_name());
        params.add(queryBookInfo.getBooks_author());
        params.add(queryBookInfo.getBooks_picture());
        params.add("无");
        params.add("未审核");
        params.add(queryreaderInfo.getReader_name());
        params.add(queryreaderInfo.getReader_id());

        //调用basedao数据库更新方法插入书籍
        BaseDao.executeUpdate(sql,params);

        //获取数据库中订单表的全部信息

        //定义获取订单信息的sql语句
        String sql2 = "select * from order_info";

        //调用basedao方法查询表中的全部内容
        List<BooksInfo> OrderInfoList = BaseDao.findAll(sql2, OrderInfo.class);

        //向前端传递Orderinfo获得的内容
        request.getSession().setAttribute("OrderInfoList",OrderInfoList);


        request.setAttribute("changePage","reader/reader_order.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void ToMyOrderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据库中订单表的全部信息

        //定义获取订单信息的sql语句
        String sql2 = "select * from order_info";

        //调用basedao方法查询表中的全部内容
        List<BooksInfo> OrderInfoList = BaseDao.findAll(sql2, OrderInfo.class);

        //向前端传递Orderinfo获得的内容
        request.getSession().setAttribute("OrderInfoList",OrderInfoList);


        request.setAttribute("changePage","reader/reader_order.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}