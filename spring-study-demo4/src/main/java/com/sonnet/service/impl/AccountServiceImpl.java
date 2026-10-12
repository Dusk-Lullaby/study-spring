package com.sonnet.service.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component(value = "accountService")
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired // 依赖注入的注解，可以完成bean的自动注入
    AccountDao accountDaoImpl2;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDaoImpl2 = accountDao;
    }

    @Override
    public void addAccount() {
        accountDaoImpl2.addAccount();
    }
}
