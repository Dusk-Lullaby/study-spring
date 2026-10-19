package com.sonnet;

import com.sonnet.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@SpringJUnitConfig(locations = {"classpath:applicationContext.xml"}) // 等价于@ExtendWith + @ContextConfiguration
public class TestJunit5 {

    @Autowired
    AccountService accountService;

    @Test //Test 注解一定要是org.junit.jupiter.api.Test
    public void test01() {
        accountService.transfer("zhangsan", "lisi", 500);
    }
}
