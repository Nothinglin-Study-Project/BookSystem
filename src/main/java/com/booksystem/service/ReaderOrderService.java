package com.booksystem.service;

import com.booksystem.dao.BooksInfoDao;
import com.booksystem.dao.LoginDao;
import com.booksystem.po.BooksInfo;
import com.booksystem.po.ReaderInfo;
import com.booksystem.vo.ResultInfo;

import java.util.List;

public class ReaderOrderService {
    //初始化查询用户信息的对象
    private LoginDao loginDao = new LoginDao();
    //获取读者的信息

    public ReaderInfo CheckReaderInfo(String readerName){
        //初始化封装集
        ReaderInfo readerInfo = new ReaderInfo();

        //查询读者数据库信息
        readerInfo = loginDao.queryReaderInfoByName(readerName);

        return readerInfo;
    }

    private BooksInfoDao booksInfoDao = new BooksInfoDao();
    //获取数据库书籍的信息
    public BooksInfo CheckBookInfo(String bookName){

        //查询书籍数据库信息
        BooksInfo booksInfo =  BooksInfoDao.findBookByName(bookName);

        return booksInfo;

    }
}
