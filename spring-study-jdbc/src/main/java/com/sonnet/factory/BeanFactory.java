package com.sonnet.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 工厂类 专门帮助我们创建对象
 */
public class BeanFactory {

     static Properties properties;

     static Map<String, Object> beans;

    // 读取properties里面的配置信息
    static {
        // 通过类加载器加载路径下面的配置文件
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        properties = new Properties();
        try {
            properties.load(resourceAsStream);
            beans = new HashMap<>();
            Enumeration<Object> keys = properties.keys();
            while(keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                // 通过key获取value
                String value = properties.getProperty(key);
                Object o = Class.forName(value).newInstance();
                beans.put(key, o);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

/*
    // 获取bean的方法
    public static Object getBean(String name) {
        // 根据key获取value的值
        String value = properties.getProperty(name);
        try {
            // 基于反射创建对象，
            // 目前创建的对象不是单例的而是多例的，
            // 原因是基于反射创建的对象不存盘，每次创建用完之后，都会被垃圾回收机制回收
            // 问题：每次调用的时候都需要重新创建对象，比较耗时，浪费性能
            Object o = Class.forName(value).newInstance();
            return o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
*/

    // 获取bean
    public static Object getBean(String name) {
        return beans.get(name);
    }
}
