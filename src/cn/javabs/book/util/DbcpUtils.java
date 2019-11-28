package cn.javabs.book.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpUtils {

    public static DataSource dataSource;

    static {
        InputStream resourceAsStream = DbcpUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        try {
            p.load(resourceAsStream);
            dataSource = BasicDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
