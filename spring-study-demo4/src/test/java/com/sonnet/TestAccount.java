package com.sonnet;

import com.sonnet.dao.AccountDao;
import com.sonnet.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) context.getBean("accountServiceImpl");
        accountService.addAccount();
        AccountDao accountDao = (AccountDao) context.getBean("accountDaoImpl");
        accountDao.addAccount();
    }
}
