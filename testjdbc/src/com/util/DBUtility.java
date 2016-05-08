package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by 1 on 2016/5/8.
 */
public class DBUtility {
    private static Properties properties = new Properties();
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String pwd = null;

    static {
        try{
            //加载db.properties文件
            properties.load(DBUtility.class.getClassLoader().getResourceAsStream("SpringMvcDemo/db.properties"));
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            pwd = properties.getProperty("jdbc.password");
            Class.forName("driver");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public  static Connection openConnection() throws SQLException{
        return DriverManager.getConnection(url,user,pwd);
    }

    public static  void closeConnectipn(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭连接时发生异常！");
            }
        }
    }
}
