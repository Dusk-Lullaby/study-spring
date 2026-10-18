package com.sonnet.dao;

import com.sonnet.pojo.Account;

public interface AccountDao {

    // 根据用户名查询账户信息
    public Account findAccountByName(String name);

    // 修改账户信息
    public void updateAccount(Account account);
}
