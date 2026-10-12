package com.sonnet.test;

import com.sonnet.pojo.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Emp emp = (Emp) context.getBean("emp");
        System.out.println(emp);
    }
}
