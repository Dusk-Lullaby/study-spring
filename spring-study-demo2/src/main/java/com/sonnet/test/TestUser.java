package com.sonnet.test;

import com.sonnet.dao.OrderDao;
import com.sonnet.dao.PersonDao;
import com.sonnet.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //UserDao userDao = (UserDao) context.getBean("userDao");
        //PersonDao personDao = (PersonDao) context.getBean("personDao");
        //personDao.addPersonDao();
        //OrderDao orderDao = (OrderDao) context.getBean("orderFactory");
        //orderDao.addOrderDao();

        UserDao userDao1 = (UserDao) context.getBean("userDao");
        UserDao userDao2 = (UserDao) context.getBean("userDao");
        System.out.println(userDao1==userDao2);
        // 销毁容器的方法
        ((ClassPathXmlApplicationContext)context).close();

    }
}
