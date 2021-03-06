package com.wilya.shop.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 本类专门负责数据库的连接与关闭操作，在实例化本类对象时就意味着要进行数据库的开发<br>
 *     所以在本类的构造方法里要进行数据库驱动加载与数据库连接取得
 */
public class DatabaseConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://120.77.222.221:3306/shop?characterEncoding=UTF-8";
    private static final String DBUSER = "root";
    private static final String PASSWORD = "yinghan9.12.25";
    private Connection conn = null;

    /**
     * 在构造方法里面为conn对象进行实例化，可以直接取得数据库的连接对象<br>
     *     由于所有的操作都是基于数据库完成的，如果数据库取得不到连接，那么也就意味着所有的操作都可以停止了
     */
    public DatabaseConnection(){
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 取得一个数据库的连接对象
     * @return Connection实例化对象
     */
    public Connection getConnection(){
        return this.conn;
    }

    /**
     * 负责数据库的关闭
     */
    public void close(){
        if (this.conn != null){
            try{
                this.conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
