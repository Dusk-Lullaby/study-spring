package com.sonnet.factory;

import com.sonnet.dao.OrderDao;
import com.sonnet.dao.impl.OrderDaoImpl;

public class OrderFactory {

    // 创建一个静态方法来管理bean
    public static OrderDao getOrder() {
        return new OrderDaoImpl();
    }
}
