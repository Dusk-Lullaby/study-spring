package com.sonnet;

import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAccount {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        List<Account> accountList = accountService.findAllAccount();
        accountList.forEach(System.out::println);
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void test03() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        Account account = new Account();
        account.setName("wangwu");
        account.setMoney(1000.0);
        accountService.saveAccount(account);
    }

    @Test
    public void test04() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        Account account = new Account();
        account.setId(3);
        account.setMoney(10086.0);
        account.setName("laoliu");
        accountService.updateAccount(account);
    }

    @Test
    public void test05() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.deleteAccount(3);
    }

}
