package com.booksystem.service;

import cn.hutool.core.util.StrUtil;
import com.booksystem.dao.LoginDao;
import com.booksystem.po.LibraryManageInfo;
import com.booksystem.po.ReaderInfo;
import com.booksystem.po.SystemManageInfo;
import com.booksystem.vo.ResultInfo;

public class LoginService {
    private LoginDao loginDao = new LoginDao();

    //----------------读者登录-------------------------------
    public ResultInfo<ReaderInfo> readerLogin(String readerName, String readerPassword) {
        //初始化处理结果对象，这个对象将返回操作状态
        ResultInfo<ReaderInfo> resultInfo = new ResultInfo<ReaderInfo>();

        //处理登录操作
        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReader_name(readerName);
        readerInfo.setReader_password(readerPassword);
        //将读者账号密码包含进处理结果对象中，方便后面的信息读取
        resultInfo.setResult(readerInfo);

        //判断用户是不是提交空白信息
        if (StrUtil.isBlank(readerName) || StrUtil.isBlank(readerPassword)) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户名或密码不能为空！");

            return resultInfo; //结束readerLogin方法
        }

        //如果用户有传递账号密码信息的话
        ReaderInfo queryReaderInfo = loginDao.queryReaderInfoByName(readerName);

        //如果数据库中没有这个用户名的话
        if (queryReaderInfo == null) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户名不存在，请前往注册读者信息！");

            return resultInfo; //结束readerLogin方法
        }

        //如果用户名存在的话，那么我要看密码和数据库的密码一不一样
        if (!readerPassword.equals(queryReaderInfo.getReader_password())) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户密码不正确，请重新检查您的密码！");

            return resultInfo; //结束readerLogin方法
        }


        //如果上面的if语句都没进入的话，那么说明输入的数据都是正确的，则登录成功
        resultInfo.setCode(1);//设置状态码为成功
        resultInfo.setResult(queryReaderInfo);//将状态码和查询结果放回给方法调用

        return resultInfo; //结束readerLogin方法


    }

    //----------------图书管理员登录-------------------------------
    public ResultInfo<LibraryManageInfo> bookManageLogin(String bookManegeName, String bookManegePassword) {
        //初始化处理结果对象，这个对象将返回操作状态
        ResultInfo<LibraryManageInfo> resultInfo = new ResultInfo<LibraryManageInfo>();

        //处理登录操作
        LibraryManageInfo libraryManageInfo = new LibraryManageInfo();
        libraryManageInfo.setLibrarymanage_name(bookManegeName);
        libraryManageInfo.setLibrarymanage_password(bookManegePassword);
        //将读者账号密码包含进处理结果对象中，方便后面的信息读取
        resultInfo.setResult(libraryManageInfo);

        //判断用户是不是提交空白信息
        if (StrUtil.isBlank(bookManegeName) || StrUtil.isBlank(bookManegePassword)) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户名或密码不能为空！");

            return resultInfo; //结束readerLogin方法
        }

        //如果用户有传递账号密码信息的话
        LibraryManageInfo queryLibraryManageInfo = loginDao.queryLibraryManageInfoByName(bookManegeName);

        //如果数据库中没有这个用户名的话
        if (queryLibraryManageInfo == null) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户名不存在，请前往注册读者信息！");

            return resultInfo; //结束readerLogin方法
        }

        //如果用户名存在的话，那么我要看密码和数据库的密码一不一样
        if (!bookManegePassword.equals(queryLibraryManageInfo.getLibrarymanage_password())) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户密码不正确，请重新检查您的密码！");

            return resultInfo; //结束readerLogin方法
        }


        //如果上面的if语句都没进入的话，那么说明输入的数据都是正确的，则登录成功
        resultInfo.setCode(1);//设置状态码为成功
        resultInfo.setResult(queryLibraryManageInfo);//将状态码和查询结果放回给方法调用

        return resultInfo; //结束readerLogin方法
    }

    //----------------系统管理员登录-------------------------------
    public ResultInfo<SystemManageInfo> systemManageLogin(String systemManegeName, String systemManegePassword) {
        //初始化处理结果对象，这个对象将返回操作状态
        ResultInfo<SystemManageInfo> resultInfo = new ResultInfo<SystemManageInfo>();

        //处理登录操作
        SystemManageInfo systemManageInfo = new SystemManageInfo();
        systemManageInfo.setSystemmanage_name(systemManegeName);
        systemManageInfo.setSystemmanage_password(systemManegePassword);
        //将读者账号密码包含进处理结果对象中，方便后面的信息读取
        resultInfo.setResult(systemManageInfo);

        //判断用户是不是提交空白信息
        if (StrUtil.isBlank(systemManegeName) || StrUtil.isBlank(systemManegePassword)) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户名或密码不能为空！");

            return resultInfo; //结束readerLogin方法
        }

        //如果用户有传递账号密码信息的话
        SystemManageInfo querySystemManageInfo = loginDao.querySystemManageInfoByName(systemManegeName);

        //如果数据库中没有这个用户名的话
        if (querySystemManageInfo == null) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户名不存在，请前往注册读者信息！");

            return resultInfo; //结束readerLogin方法
        }

        //如果用户名存在的话，那么我要看密码和数据库的密码一不一样
        if (!systemManegePassword.equals(querySystemManageInfo.getSystemmanage_password())) {
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户密码不正确，请重新检查您的密码！");

            return resultInfo; //结束readerLogin方法
        }


        //如果上面的if语句都没进入的话，那么说明输入的数据都是正确的，则登录成功
        resultInfo.setCode(1);//设置状态码为成功
        resultInfo.setResult(querySystemManageInfo);//将状态码和查询结果放回给方法调用

        return resultInfo; //结束readerLogin方法
    }
}
