package com.booksystem.web;


import com.booksystem.dao.BaseDao;
import com.booksystem.dao.BooksInfoDao;
import com.booksystem.po.BooksInfo;
import com.booksystem.po.BorrowBookInfo;
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

@WebServlet("/bookmanage")
public class BookManageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断用户行为并执行指定函数
        String actionName = request.getParameter("actionName");
        if ("manageorder".equals(actionName)) {
            ManageOrder(request, response);
        }else if ("agreeorder".equals(actionName)){
            AgreeOrder(request, response);
        }else if ("disagreeorder".equals(actionName)){
            DeleteOrder(request, response);
        }else if("borrowbookpage".equals(actionName)){
            BorrowBookPage(request,response);
        }else if ("borrowBook".equals(actionName)){
            BorrowBook(request,response);
        }else if ("checkborrow".equals(actionName)){
            CheckBorrow(request,response);
        }else if ("giveback".equals(actionName)){
            GiveBack(request,response);
        }

    }

    private void GiveBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String borrowBookIsbn = request.getParameter("borrowBookIsbn");
        //定义删除借出表中的信息的sql语句
        String sql = "delete from borrow_info where bookisbn = ?";
        List<Object> params = new ArrayList<>();
        params.add(borrowBookIsbn);

        //调用basedao数据库向借书表中删除要还书的信息
        BaseDao.executeUpdate(sql,params);

        //定义sql语句更新书籍列表中的书籍状态
        String sql2 = "update books_info set books_status = ? where books_isbn = ?";
        List<Object> params2 = new ArrayList<>();
        params2.add("在馆未借");
        params2.add(borrowBookIsbn);
        //调用basedao数据库更新书籍库中的书籍状态
        BaseDao.executeUpdate(sql2,params2);


        //刷新借书表的内容
        //定义sql语句查询借书表中的全部内容
        String sql1 = "select * from borrow_info";
        //调用basedao中查询表全部内容的方法
        List<BorrowBookInfo> borrowbookinfo = BaseDao.findAll(sql1,BorrowBookInfo.class);

        request.getSession().removeAttribute("borrowbookinfo");
        request.getSession().setAttribute("borrowbookinfo",borrowbookinfo);

        request.setAttribute("changePage","bookmanage/borrow_list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

        request.getSession().removeAttribute("borrowbookinfo");
        request.getSession().setAttribute("borrowbookinfo",borrowbookinfo);

        request.setAttribute("changePage","bookmanage/borrow_list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void CheckBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义sql语句查询借书表中的全部内容
        String sql = "select * from borrow_info";
        //调用basedao中查询表全部内容的方法
        List<BorrowBookInfo> borrowbookinfo = BaseDao.findAll(sql,BorrowBookInfo.class);

        request.getSession().removeAttribute("borrowbookinfo");
        request.getSession().setAttribute("borrowbookinfo",borrowbookinfo);

        request.setAttribute("changePage","bookmanage/borrow_list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    //处理借书事务
    private void BorrowBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String BookName = request.getParameter("infoBookname");
        String BookIsbn = request.getParameter("infoBookisbn");
        String BookPicture = request.getParameter("infoBookpicture");
        String BookStatus = request.getParameter("infoBookstatus");
        String readerName = request.getParameter("readerName");
        String backTime = request.getParameter("backTime");
        String readerId = request.getParameter("readerId");
        String readerNumber = request.getParameter("readerNumber");

        //定义向订单表中插入预定信息的sql语句
        String sql = "insert into borrow_info(readername , bookname , picture , bookstatus , readerid , backtime , bookisbn ,readerNumber) values(?,?,?,?,?,?,?,?)";

        List<Object> params = new ArrayList<>();
        params.add(readerName);
        params.add(BookName);
        params.add(BookPicture);
        params.add("未归还");
        params.add(readerId);
        params.add(backTime);
        params.add(BookIsbn);
        params.add(readerNumber);

        //调用basedao数据库向借书表中插入借书信息
        BaseDao.executeUpdate(sql,params);

        //更新书籍表中的书籍状态
        //定义sql语句
        String sql1 = "update books_info set books_status = ? where books_isbn = ?";
        List<Object> params1 = new ArrayList<>();
        params1.add("不在馆，已借出");
        params1.add(BookIsbn);

        //调用basedao数据库更新方法插入书籍
        BaseDao.executeUpdate(sql1,params1);


        //刷新
        //定义sql语句查询借书表中的全部内容
        String sql2 = "select * from borrow_info";
        //调用basedao中查询表全部内容的方法
        List<BorrowBookInfo> borrowbookinfo = BaseDao.findAll(sql2,BorrowBookInfo.class);

        request.getSession().removeAttribute("borrowbookinfo");
        request.getSession().setAttribute("borrowbookinfo",borrowbookinfo);
        request.setAttribute("changePage","bookmanage/borrow_list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);



    }

    //跳转到借出页面
    private void BorrowBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //跳转回预约管理中
        request.setAttribute("changePage","bookmanage/bookborrow_page.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void DeleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookisbn = request.getParameter("bookisbn");

        //删除不符合预约条件的预约
        //定义sql语句
        String sql = "delete from order_info where bookisbn = ?";
        List<Object> params = new ArrayList<>();
        params.add(bookisbn);
        //调用basedao数据库删除预约表中不符合预约条件的信息
        BaseDao.executeUpdate(sql,params);

        //刷新预约表中的信息
        //定义sql语句
        String sql2 = "select * from order_info";

        //调用basedao方法查询表中的全部内容
        List<BooksInfo> OrderInfoList = BaseDao.findAll(sql2, OrderInfo.class);

        //1.销毁Session对象
        request.getSession().removeAttribute("OrderInfoList");
        //向前端传递Orderinfo获得的内容
        request.getSession().setAttribute("OrderInfoList",OrderInfoList);

        //跳转回预约管理中
        request.setAttribute("changePage","bookmanage/order_manage.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void AgreeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookisbn = request.getParameter("bookisbn");

        //更改数据库中的预约表中的书籍预约状态
        //定义sql语句
        String sql = "update order_info set orderstatus = ? where bookisbn = ?";
        List<Object> params = new ArrayList<>();
        params.add("已审核");
        params.add(bookisbn);

        //调用basedao数据库更新方法插入书籍
        BaseDao.executeUpdate(sql,params);

        //更新书籍表中的书籍状态
        String sql1 = "update books_info set books_status = ? where books_isbn = ?";
        List<Object> params1 = new ArrayList<>();
        params1.add("在馆预约中(暂不可借)");
        params1.add(bookisbn);

        //调用basedao数据库更新方法插入书籍
        BaseDao.executeUpdate(sql1,params1);

        //刷新预约表中的信息
        //定义sql语句
        String sql2 = "select * from order_info";

        //调用basedao方法查询表中的全部内容
        List<BooksInfo> OrderInfoList = BaseDao.findAll(sql2, OrderInfo.class);

        //1.销毁Session对象
        request.getSession().removeAttribute("OrderInfoList");
        //向前端传递Orderinfo获得的内容
        request.getSession().setAttribute("OrderInfoList",OrderInfoList);

        //跳转回预约管理中
        request.setAttribute("changePage","bookmanage/order_manage.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void ManageOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取读者预约信息表中的数据
        //定义sql语句
        String sql = "select * from order_info";

        //调用basedao方法查询表中的全部内容
        List<BooksInfo> OrderInfoList = BaseDao.findAll(sql, OrderInfo.class);

        //向前端传递Orderinfo获得的内容
        request.getSession().setAttribute("OrderInfoList",OrderInfoList);

        request.setAttribute("changePage","bookmanage/order_manage.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }


}