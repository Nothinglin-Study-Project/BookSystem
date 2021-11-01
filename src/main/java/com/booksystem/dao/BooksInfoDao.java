package com.booksystem.dao;

import com.booksystem.po.BooksInfo;

import java.util.ArrayList;
import java.util.List;

public class BooksInfoDao {

    public static List findAll() {
        String sql = "select * from books_info";
        //3.调用BaseDao的查询方法
        List<BooksInfo> BooksInfo = BaseDao.findAll(sql, BooksInfo.class);

        return BooksInfo;
    }

    //查找数据库中计算机类型的书籍
    public static List findComputerBooks(String booksType){
        //1.定义sql语句
        String sql = "select * from books_info where books_type = ?";
        //2.设置参数集合
        List<Object> params = new ArrayList<Object>();
        params.add(booksType);

        //调用basedao方法
        List ComputerBooks = BaseDao.queryRows(sql,params,BooksInfo.class);

        return ComputerBooks;
    }

    //根据书名查询书籍的信息
    public static BooksInfo findBookByName(String bookName){
        //1.定义sql语句
        String sql = "select * from books_info where books_name = ?";
        //2.设置参数集合
        List<Object> params = new ArrayList<Object>();
        params.add(bookName);

        //调用basedao方法
        BooksInfo findBookInfo = (BooksInfo) BaseDao.queryRow(sql,params,BooksInfo.class);

        return findBookInfo;
    }
}
