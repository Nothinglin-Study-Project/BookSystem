package com.booksystem.po;

public class ReaderInfo {
    private String reader_id;//用户身份证号码
    private String reader_name;//用户名字
    private String reader_password;//用户密码
    private String reader_number;//用户电话号码
    private String reader_status;//用户借书状态

    public String getReader_id() {
        return reader_id;
    }

    public void setReader_id(String reader_id) {
        this.reader_id = reader_id;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public String getReader_password() {
        return reader_password;
    }

    public void setReader_password(String reader_password) {
        this.reader_password = reader_password;
    }

    public String getReader_number() {
        return reader_number;
    }

    public void setReader_number(String reader_number) {
        this.reader_number = reader_number;
    }

    public String getReader_status() {
        return reader_status;
    }

    public void setReader_status(String reader_status) {
        this.reader_status = reader_status;
    }
}
