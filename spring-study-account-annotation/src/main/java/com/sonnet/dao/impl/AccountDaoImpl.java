package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    // 操作数据库的核心类
    @Autowired
    private QueryRunner runner;

    //public void setRunner(QueryRunner runner) {
    //    this.runner = runner;
    //}

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        try {
            return runner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        String sql = "select * from account where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        String sql = "insert into account(name, money) value(?,?)";
        try {
            runner.update(sql, account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set name=?, money=? where id=?";
        try {
            runner.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        String sql = "delete from account where id=?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
