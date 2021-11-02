package com.booksystem.dao;

import com.booksystem.po.ReaderInfo;
import com.booksystem.po.LibraryManageInfo;

import java.util.ArrayList;
import java.util.List;

public class LoginDao {
    public ReaderInfo queryReaderInfoByName(String readerName){
        //1.定义sql语句
        String sql = "select * from reader_info where reader_name = ?";

        //2.设置参数集合
        List<Object> params = new ArrayList<Object>();
        params.add(readerName);

        //3.调用baseDao查询方法
        ReaderInfo readerInfo = (ReaderInfo) BaseDao.queryRow(sql,params,ReaderInfo.class);

        return readerInfo;
    }

    public LibraryManageInfo queryLibraryManageInfoByName(String bookManageName){
        //1.定义sql语句
        String sql = "select * from librarymanage_info where librarymanage_name = ?";

        //2.设置参数集合
        List<Object> params = new ArrayList<Object>();
        params.add(bookManageName);

        LibraryManageInfo libraryManageInfo = (LibraryManageInfo) BaseDao.queryRow(sql,params,LibraryManageInfo.class);
        return libraryManageInfo;
    }
}
