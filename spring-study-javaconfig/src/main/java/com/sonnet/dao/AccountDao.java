package com.sonnet.dao;

import com.sonnet.pojo.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户信息
     *
     * @return 账户信息集合
     */
    List<Account> findAllAccount();

    /**
     * 查询指定的账户信息
     *
     * @param id 账户id
     * @return 账户
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户信息
     *
     * @param account 账户
     */
    void saveAccount(Account account);

    /**
     * 更新账户信息
     *
     * @param account 账户
     */
    void updateAccount(Account account);

    /**
     * 删除账户信息
     *
     * @param id 账户id
     */
    void deleteAccount(Integer id);

}
