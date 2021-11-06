package com.booksystem.po;

/**
 * 1.先写po，数据对应数据库的表元素
 */
public class BooksInfo {
    private String books_isbn;  //书籍的ID
    private String books_name; //书籍的名称
    private String books_author; //书籍的作者
    private String books_intro; //书籍简介
    private String books_position; //书籍的位置
    private String books_status; //书籍的状态
    private String books_type;//书籍的类型
    private String books_picture; //书籍的封面

    public String getBooks_isbn() {
        return books_isbn;
    }

    public void setBooks_isbn(String books_isbn) {
        this.books_isbn = books_isbn;
    }

    public String getBooks_name() {
        return books_name;
    }

    public void setBooks_name(String books_name) {
        this.books_name = books_name;
    }

    public String getBooks_author() {
        return books_author;
    }

    public void setBooks_author(String books_author) {
        this.books_author = books_author;
    }

    public String getBooks_intro() {
        return books_intro;
    }

    public void setBooks_intro(String books_intro) {
        this.books_intro = books_intro;
    }

    public String getBooks_position() {
        return books_position;
    }

    public void setBooks_position(String books_position) {
        this.books_position = books_position;
    }

    public String getBooks_status() {
        return books_status;
    }

    public void setBooks_status(String books_status) {
        this.books_status = books_status;
    }

    public String getBooks_type() {
        return books_type;
    }

    public void setBooks_type(String books_type) {
        this.books_type = books_type;
    }

    public String getBooks_picture() {
        return books_picture;
    }

    public void setBooks_picture(String books_picture) {
        this.books_picture = books_picture;
    }
}
