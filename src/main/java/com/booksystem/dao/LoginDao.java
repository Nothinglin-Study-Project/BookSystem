package com.booksystem.dao;

import com.booksystem.po.ReaderInfo;

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
}
