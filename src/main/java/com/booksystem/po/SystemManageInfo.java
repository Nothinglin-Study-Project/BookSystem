package com.booksystem.po;

public class SystemManageInfo {
    private int systemmanage_id;//系统管理员的id
    private String systemmanage_name;//系统管理员name
    private String systemmanage_password;//系统管理员登录密码

    public int getSystemmanage_id() {
        return systemmanage_id;
    }

    public void setSystemmanage_id(int systemmanage_id) {
        this.systemmanage_id = systemmanage_id;
    }

    public String getSystemmanage_name() {
        return systemmanage_name;
    }

    public void setSystemmanage_name(String systemmanage_name) {
        this.systemmanage_name = systemmanage_name;
    }

    public String getSystemmanage_password() {
        return systemmanage_password;
    }

    public void setSystemmanage_password(String systemmanage_password) {
        this.systemmanage_password = systemmanage_password;
    }
}
