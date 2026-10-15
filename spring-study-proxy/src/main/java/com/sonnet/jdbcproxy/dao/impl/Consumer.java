package com.sonnet.jdbcproxy.dao.impl;

import com.sonnet.jdbcproxy.dao.ProductDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 让代理对象帮助我们购买电脑
 */
public class Consumer {
    public static void main(String[] args) {
        // 自己购买电脑
        Producer producer = new Producer();
        producer.buyProduct("自己");

        // 模拟代理对象购买电脑
        /**
         * newProxyInstance 产生代理对象
         *      参数1：接口实现类的类加载器
         *      参数2：字节码数组对象
         *      参数3：真正干活的对象
         */
        ProductDao proxy = (ProductDao) Proxy.newProxyInstance(Producer.class.getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 当前代理对象的引用
             * @param method 当前执行的方法对象
             * @param args 执行当前方法需要用到的参数
             * @return 需要被增强方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("buyProduct")) {
                    method.invoke(producer, args);
                }
                return null;
            }
        });
        proxy.buyProduct("代理对象");
    }
}
