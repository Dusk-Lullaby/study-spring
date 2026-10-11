package com.sonnet.service.impl;

import com.sonnet.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl初始化完成");
    }

    @Override
    public void addAccount() {
        System.out.println("accountService方法被实现");
    }
}
