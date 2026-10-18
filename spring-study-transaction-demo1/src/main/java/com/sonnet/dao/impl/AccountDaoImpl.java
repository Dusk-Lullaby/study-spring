package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import com.sonnet.rowmapper.MyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountByName(String name) {
        String sql = "select * from account where name = ?";
        List<Account> accountList = jdbcTemplate.query(sql, new MyRowMapper(), name);
        return accountList.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set money = ? where name = ?";
        jdbcTemplate.update(sql, account.getMoney(), account.getName());
    }
}
