package com.sonnet.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 将当前线程对象和数据库连接进行绑定，保证业务类里面的数据库连接对象一直是同一个数据库连接对象
 */
@Component
public class ConnectionUtils {

    @Autowired
    DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    // 获取数据库连接
    public Connection getConnection() {
        Connection connection = threadLocal.get();
        try {
            if (connection == null) { // 当前线程对象上没有绑定数据库连接
                // 从数据库连接池里面获取一个连接到对象绑定到ThreadLocal上
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    // 将当前线程和数据库连接对象解绑
    public void removeConnection() {
        threadLocal.remove();
    }
}
