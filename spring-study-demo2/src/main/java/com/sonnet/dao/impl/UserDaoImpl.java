package com.sonnet.dao.impl;

import com.sonnet.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("UserDao的无参数构造函数实现了");
    }

    @Override
    public void addUser() {
        System.out.println("新增用户方法被实现");
    }

    // 描述bean初始化需要执行的方法
    public void init() {
        System.out.println("init");
    }
    // 描述bean销毁的时候需要执行的方法
    public void destroy() {
        System.out.println("destroy");
    }
}
