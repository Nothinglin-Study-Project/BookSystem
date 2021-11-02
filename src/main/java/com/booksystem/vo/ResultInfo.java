package com.booksystem.vo;

/**
 * 封装返回结果的类
 *      状态码
 *          成功=1，失败=0
 *      提示信息
 *      返回的对象
 */
//泛型<T>可以保证返回的数据可以是任意类型

public class ResultInfo<T> {
    private Integer code;//状态码，成功=1，失败=0
    private String msg;//提示信息
    private T result;//返回的对象（字符串、JavaBean、集合、Map)

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
