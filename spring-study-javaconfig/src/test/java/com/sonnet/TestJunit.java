package com.sonnet;

import com.sonnet.config.BeanConfig;
import com.sonnet.config.SpringConfiguration;
import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 测试模板类需要用到一个测试启动器
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 将测试模板类中也引入IOC环境
@ContextConfiguration(classes = {SpringConfiguration.class, BeanConfig.class}) // 将测试模板类中也引入IOC环境
public class TestJunit {
    @Autowired
    AccountService accountService;

    @Test
    public void test01() {
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

}
