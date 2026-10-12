package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component(value = "accountDao")
@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void addAccount() {
        System.out.println("addAccount 被实现");
    }
}
