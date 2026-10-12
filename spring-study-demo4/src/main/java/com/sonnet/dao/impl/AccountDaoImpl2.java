package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;
import org.springframework.stereotype.Repository;

//@Component(value = "accountService")
@Repository
public class AccountDaoImpl2 implements AccountDao {

    @Override
    public void addAccount() {
        System.out.println("新增账户的方法实现了2222");
    }
}
