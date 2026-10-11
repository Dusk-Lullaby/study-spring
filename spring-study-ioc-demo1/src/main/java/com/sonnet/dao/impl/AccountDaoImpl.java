package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    public AccountDaoImpl() {
        System.out.println("AccountDaoImpl初始化完成");
    }

    @Override
    public void addAccount() {
        System.out.println("新增账户的方法被实现了");
    }
}
