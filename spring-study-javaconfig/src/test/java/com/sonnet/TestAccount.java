package com.sonnet;

import com.sonnet.config.SpringConfiguration;
import com.sonnet.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAccount {

    @Test
    public void test01() {
        ApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.findAllAccount().forEach(System.out::println);
    }
}
