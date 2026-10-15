package com.sonnet.factory;

import com.sonnet.service.AccountService;
import com.sonnet.utils.TransactionManger;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂类 专门帮助我们产生代理对象
 */
public class ProxyFactory {

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionManger transactionManger;

    /**
     * 产生代理对象的方法
     * @return
     */
    public AccountService getAccountService() {
        AccountService proxy = (AccountService) Proxy.newProxyInstance(AccountService.class.getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    if (method.getName().equals("transfer"))
                        // 开启事务
                        transactionManger.beginTransactionManger();
                        // 执行业务操作
                        method.invoke(accountService, args);
                        // 提交事务
                        transactionManger.commit();
                } catch (Exception e) {
                    // 回滚事务
                    transactionManger.rollBack();
                    throw new Exception();
                } finally {
                    // 释放资源
                    transactionManger.release();
                }
                return null;
            }
        });
        return proxy;
    }
}
