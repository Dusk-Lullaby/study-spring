package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    QueryRunner queryRunner;

    // 根据用户名查询账户信息是否存在
    @Override
    public Account findAccountByName(String name) {
        String sql = "select * from account where name = ?";
        try {
            return queryRunner.query(sql, new BeanHandler<Account>(Account.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set money=? where name=?";
        try {
            queryRunner.update(sql, account.getMoney(), account.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
