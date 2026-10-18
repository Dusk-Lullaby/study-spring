package com.sonnet.service.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public void transfer(final String sourceName, final String targetName, final double money) {

        transactionTemplate .execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //根据账户名称查询对应的账户
                Account sourceAccount = accountDao.findAccountByName(sourceName);
                Account targetAccount = accountDao.findAccountByName(targetName);
                if (sourceAccount.getMoney() >= money) {
                    sourceAccount.setMoney(sourceAccount.getMoney() - money);
                    targetAccount.setMoney(targetAccount.getMoney() + money);
                    // 执行金额的修改
                    accountDao.updateAccount(sourceAccount);
                    //int i = 10 / 0;
                    accountDao.updateAccount(targetAccount);
                }
            }
        });
    }
}
