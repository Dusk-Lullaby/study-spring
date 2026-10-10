package com.sonnet.jdbc;

import com.sonnet.service.AccountService;
import com.sonnet.service.impl.AccountServiceImpl;

public class TestAccount {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            AccountService accountService = new AccountServiceImpl();
            System.out.println();
            accountService.addAccount();
        }
    }
}
