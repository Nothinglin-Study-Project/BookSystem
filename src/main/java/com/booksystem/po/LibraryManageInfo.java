package com.booksystem.po;

public class LibraryManageInfo {
    //这里的名字要对应数据库中的数据
    private String librarymanage_id;//图书管理员id
    private String librarymanage_name;//图书管理员name
    private String librarymanage_password;//图书管理员密码

    public String getLibrarymanage_id() {
        return librarymanage_id;
    }

    public void setLibrarymanage_id(String librarymanage_id) {
        this.librarymanage_id = librarymanage_id;
    }

    public String getLibrarymanage_name() {
        return librarymanage_name;
    }

    public void setLibrarymanage_name(String librarymanage_name) {
        this.librarymanage_name = librarymanage_name;
    }

    public String getLibrarymanage_password() {
        return librarymanage_password;
    }

    public void setLibrarymanage_password(String librarymanage_password) {
        this.librarymanage_password = librarymanage_password;
    }
}
