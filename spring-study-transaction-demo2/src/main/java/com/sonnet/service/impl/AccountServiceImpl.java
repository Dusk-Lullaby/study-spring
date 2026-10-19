package com.sonnet.service.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Transactional注解既可以放在业务类上，也可以放在方法上
 * 如果放在业务类上面，意味着当前业务类中的所有方法都会被事务控制，并且应用的都是同一钟事务隔离级别和事务传播行为
 * 如果放在业务方法上，意味着我们可以对指定的业务方法进行事务控制，并且对不同的业务方法设置不同的事务隔离级别和传播行为
 */
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public void transfer(final String sourceName, final String targetName, final double money) {
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
}
