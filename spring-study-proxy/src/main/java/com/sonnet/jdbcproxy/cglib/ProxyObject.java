package com.sonnet.jdbcproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟代理对象购买电脑
 */
public class ProxyObject {
    public static void main(String[] args) {
        // 模拟自己买电脑
        Provider provider = new Provider();
        provider.buyProduct("自己");
        // 模拟代理对象购买电脑
        /**
         * create 产生代理对象的方法
         *      参数1：当前代理的类的字节码对象
         *      参数2：真正干活的对象
         */
        Provider proxy = (Provider) Enhancer.create(Provider.class, new MethodInterceptor() {
            /**
             * 具体进行增强的方法
             * @param o 当前代理对象的引用
             * @param method 代理对象需要进行增强的方法对象
             * @param objects 代理对象需要增强方法要用到的参数
             * @param methodProxy 执行方法的代理对象，一般不用
             * @return 和被增强的方法一样的返回值
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("buyProduct")) {
                    return method.invoke(provider, objects);
                }
                return methodProxy.invokeSuper(o, objects);
            }
        });
        proxy.buyProduct("代理对象");
    }
}
