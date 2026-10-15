package com.sonnet.jdbcproxy.dao.impl;

import com.sonnet.jdbcproxy.dao.ProductDao;

/**
 * 手动模拟购买电脑
 */
public class Producer implements ProductDao {
    @Override
    public void buyProduct(String name) {
        System.out.println(name + "购买了电脑");
    }
}
