package com.sonnet.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Animal {

    @Value("1001")
    private Integer id;

    @Value("芙蓉花")
    private String name;

    @Value("green")
    private String color;

    @Value("2")
    private Integer age;

    // bean初始化的方法
    @PostConstruct // 初始化方法执行的注解 init-method
    public void init() {
        System.out.println("init 执行了");
    }

    // bean销毁的方法
    @PreDestroy // bean销毁的时候执行的方法 destroy-method
    public void destroy() {
        System.out.println("destroy 执行了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
