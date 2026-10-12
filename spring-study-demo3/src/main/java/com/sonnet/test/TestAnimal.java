package com.sonnet.test;

import com.sonnet.pojo.Animal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnimal {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Animal animal = (Animal) context.getBean("animal");
        System.out.println(animal);
    }
}
