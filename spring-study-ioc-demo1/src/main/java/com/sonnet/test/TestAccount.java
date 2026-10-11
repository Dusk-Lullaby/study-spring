package com.sonnet.test;

import com.sonnet.dao.AccountDao;
import com.sonnet.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestAccount {

    public static void main(String[] args) {
/*
        //// 读取spring的配置文件来初始化一个ioc容器
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //// 获取bean
        //AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        //accountDao.addAccount();
        //AccountService accountService = (AccountService) context.getBean("accountService");
        //accountService.addAccount();
*/

        // 通过BeanFactory的方式来创建对象
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        AccountDao accountDao = (AccountDao) beanFactory.getBean("accountDao");
        AccountService accountService = (AccountService) beanFactory.getBean("accountService");
        accountDao.addAccount();
        accountService.addAccount();
    }
}
