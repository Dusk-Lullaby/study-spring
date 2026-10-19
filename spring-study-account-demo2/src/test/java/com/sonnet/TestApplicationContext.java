package com.sonnet;

import com.sonnet.pojo.Account;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

public class TestApplicationContext {

    @Test
    public void testGenericApplicationContext() {
        // 1. 创建GenericApplicationContext核心对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 2. 刷新一下容器
        context.refresh();
        // 3. 容器注册bean的方法，来注册bean到ioc容器
        context.registerBean("account", Account.class, ()->new Account(1002, "goudan", 900.0));
        // 4. 获取容器中的注册的bean
        Account  account = (Account) context.getBean("account");
        System.out.println(account);
    }
}
