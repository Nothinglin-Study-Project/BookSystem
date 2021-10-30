package com.booksystem.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 这个为数据库连接的工具类，对应db.properties文件中的内容
 */

public class DBUtil {

    //② 获取配置对象中数据库中的连接信息
    private static Properties properties = new Properties();

    static {
        //因为在加载的过程中可能会出现异常，需要报出对应位置的错误，这里需要使用try..catch..来捕获异常
        try {
            //③
            //加载配置文件，找到db.properties文件并且获取其中的数据
            InputStream in = com.booksystem.util.DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //通过load方法加载文件中的内容到上面的properties变量中
            properties.load(in);

            //④通过配置文件对象的getProperty()方法加载DB.properties文件中的属性及其属性值并进行加载
            //获取db.properties文件中的jdbcName属性的属性值
            //这里是获取db文件中的mysql数据库驱动的信息
            Class.forName(properties.getProperty("jdbcName"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */

    //①我们首先要定义一个数据库连接方法，既然连接数据库就要获得数据的相关数据信息
    public static Connection getConnection() {
        Connection connection = null;
        //⑦连接的过程可能会出错，需要错误异常定位
        try {
            //⑤得到数据库连接的对应信息
            String dbUrl = properties.getProperty("dbUrl");
            String dbName = properties.getProperty("dbName");
            String dbPwd = properties.getProperty("dbPwd");

            //⑥得到数据库连接,对数据库进行驱动加载且传入数据进行连接
            connection = DriverManager.getConnection(dbUrl, dbName, dbPwd);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     * @param resultSet
     * @param preparedStatement
     * @param connection
     */
    //⑦数据库资源关闭
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {

        //异常追踪需要加上
        try {
            //⑧判断资源如果不为空，则关闭(也就是说，相关的对象获取到了数据库的资源之后就可以关闭mysql数据库驱动连接了，这样可以节省资源，一直开启连接状态很浪费系统资源)
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
