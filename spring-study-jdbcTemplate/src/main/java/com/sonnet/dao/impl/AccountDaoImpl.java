package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import com.sonnet.rowmapper.MyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer id) {
        String sql = "select * from account where id = ?";
        List<Account> accountList = jdbcTemplate.query(sql, new MyRowMapper(), 1);
        return accountList.get(0);
    }

    @Override
    public void addAccount(Account account) {
        String sql = "insert into account(name, money) values(?,?)";
        jdbcTemplate.update(sql, account.getName(), account.getMoney());
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set name = ?, money = ? where id = ?";
        jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteAccount(Integer id) {
        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
