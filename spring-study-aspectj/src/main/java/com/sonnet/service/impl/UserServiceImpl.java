package com.sonnet.service.impl;

import com.sonnet.service.UserService;

/**
 * 目标类
 */
public class UserServiceImpl implements UserService {
    @Override
    public void findAll() {
        System.out.println("findAll");
    }

    @Override
    public void addUser() {
        //int a = 1/ 0;
        System.out.println("addUser");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser");

    }
}
