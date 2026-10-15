package com.sonnet;

import com.sonnet.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestAccount {

    @Autowired
    @Qualifier("proxy") // 指定获取容器中 名为proxy的这个bean对象
    AccountService accountService;

    @Test
    public void test01() {
        accountService.transfer("zhangsan", "lisi", 500.0);
    }
}
