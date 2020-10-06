package cn.itcast.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用的Durid连接池
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            //使用classloader加载配置文件 获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"); //字节输入流
            properties.load(is);
            //初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //获取连接connection对象
    public static Connection getConnection() throws SQLException {
         return ds.getConnection();
    }
}