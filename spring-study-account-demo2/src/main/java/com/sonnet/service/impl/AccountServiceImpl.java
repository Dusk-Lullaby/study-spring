package com.sonnet.service.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import com.sonnet.utils.TransactionManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 什么是事务，事务指的是一组逻辑操作，这些操作是最小单位不可分割的，这些操作要么全部执行成功，要么全部执行失败
 * 事务的特性：ACID原则
 *      A：原子性 事务的逻辑操作必须是最小单位，不可分割的
 *      C：一致性 指的是事务提交前和事务提交后的数据必须保持一致
 *      I：隔离性 指的是多个事务之前必须互相独立不能影响
 *      D：持久性 指的是事务提交之后数据必须持久化的保存在数据表中
 * 事务的提交级别
 *      读未提交：一个事务读到了另一个事务没有提交的数据，容易造成脏读的数据
 *      读已提交：Oracle数据库默认的事务隔离级别，解决了脏读数据的出现，但是出现了不可重复读的现象
 *      可重复读：MySQL默认的事务级别，解决了不可重复读的问题，但出现了幻读的问题，
 *      可串行话：解决了所有事务的问题（脏读，重复读，幻读）
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

/*     @Autowired
    TransactionManger transactionManger; */

    /**
     * 首先判断转出人账户和转入人账户是否存在，如果存在，继续判断转出人的账户金额是否足够。
     * 如果足够，再执行金额的扣账入账操作
     * @param sourceName 转出人的账户姓名
     * @param targetName 转入人的账户姓名
     * @param money 转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Double money) {

        // 查询转出人的账户信息
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        // 查询转入人的账户信息
        Account targetAccount = accountDao.findAccountByName(targetName);
        if (sourceAccount != null && targetAccount != null) {
            if (sourceAccount.getMoney() >= money) {
                // 设置转出人的转账金额
                sourceAccount.setMoney(sourceAccount.getMoney() - money);
                // 设置转入人的账户金额
                targetAccount.setMoney(targetAccount.getMoney() + money);
                // 更新账户
                accountDao.updateAccount(sourceAccount);
                accountDao.updateAccount(targetAccount);
            }
        }

/*
        try {
            transactionManger.beginTransactionManger();
            // 查询转出人的账户信息
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            // 查询转入人的账户信息
            Account targetAccount = accountDao.findAccountByName(targetName);
            if (sourceAccount != null && targetAccount != null) {
                if (sourceAccount.getMoney() >= money) {
                    // 设置转出人的转账金额
                    sourceAccount.setMoney(sourceAccount.getMoney() - money);
                    // 设置转入人的账户金额
                    targetAccount.setMoney(targetAccount.getMoney() + money);
                    // 更新账户
                    accountDao.updateAccount(sourceAccount);
                    accountDao.updateAccount(targetAccount);
                }
            }
            transactionManger.commit();
        } catch (Exception e) {
            transactionManger.rollBack();
            throw new RuntimeException();
        } finally {
            transactionManger.release();
        }
*/
    }
}
