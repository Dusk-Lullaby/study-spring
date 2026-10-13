package com.sonnet.service.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Scope(value = "singleton") // 描述bean的作用域的注解 prototype多例bean singleton单例bean
public class AccountServiceImpl implements AccountService {

/*
    //@Autowired // 依赖注入的注解，可以完成bean的自动注入
    @Qualifier("accountDaoImpl")
    AccountDao accountDao;
*/

    //@Resource(name = "accountDaoImpl2") // 默认按照名称进行匹配
    //@Resource(type = AccountDao.class, name = "accountDaoImpl2") // 按照类型注入 容器中必须只能存在类型唯一的bean 否则抛异常
    @Resource(type = AccountDao.class)
    @Qualifier("accountDaoImpl2")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void addAccount() {
        System.out.println("addAccount");
    }
}
