package com.sonnet.service.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

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
                //int a = 10 / 0;
                accountDao.updateAccount(targetAccount);
            }
        }
    }
}
