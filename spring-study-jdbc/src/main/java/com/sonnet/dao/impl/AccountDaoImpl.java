package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println("基于JDBC技术新增了Account");
    }
}
