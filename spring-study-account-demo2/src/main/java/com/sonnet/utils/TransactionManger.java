package com.sonnet.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务管理器 里面定义了开启事务 提交事务 回滚事务 释放资源的方法
 */
@Component
public class TransactionManger {

    @Autowired
    ConnectionUtils connectionUtils;

    /**
     * 开启事务的方法 关闭事务的自动提交
     */
    public void beginTransactionManger() {
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务的方法
     */
    public void commit() {
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务的方法
     */
    public void rollBack() {
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放资源的方法
     */
    public void release() {
        try {
            connectionUtils.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}