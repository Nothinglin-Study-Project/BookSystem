package com.booksystem.service;

import cn.hutool.core.util.StrUtil;
import com.booksystem.dao.LoginDao;
import com.booksystem.po.ReaderInfo;
import com.booksystem.vo.ResultInfo;

public class LoginService {
    private LoginDao loginDao = new LoginDao();

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
        if (queryReaderInfo == null){
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户名不存在，请前往注册读者信息！");

            return resultInfo; //结束readerLogin方法
        }

        //如果用户名存在的话，那么我要看密码和数据库的密码一不一样
        if (!readerPassword.equals(queryReaderInfo.getReader_password())){
            resultInfo.setCode(0);//设置状态码为失败
            resultInfo.setMsg("用户密码不正确，请重新检查您的密码！");

            return resultInfo; //结束readerLogin方法
        }


        //如果上面的if语句都没进入的话，那么说明输入的数据都是正确的，则登录成功
        resultInfo.setCode(1);//设置状态码为成功
        resultInfo.setResult(queryReaderInfo);//将状态码和查询结果放回给方法调用

        return resultInfo; //结束readerLogin方法


    }
}
