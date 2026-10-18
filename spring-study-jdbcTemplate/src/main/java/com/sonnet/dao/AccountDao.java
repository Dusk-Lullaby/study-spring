package com.sonnet.dao;

import com.sonnet.pojo.Account;

public interface AccountDao {

    // 根据ID查询指定的账户信息
    public Account findAccountById(Integer id);

    // 新增账户信息
    public void addAccount(Account account);

    // 修改账户信息
    public void updateAccount(Account account);

    // 删除账户信息
    public void deleteAccount(Integer id);
}
