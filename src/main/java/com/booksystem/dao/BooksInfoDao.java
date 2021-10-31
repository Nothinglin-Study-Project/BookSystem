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
}
