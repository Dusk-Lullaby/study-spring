package com.sonnet.dao.impl;

import com.sonnet.dao.AccountDao;

public class MybatisAccountDaoImpl implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println("基于mybatis技术新增Account");
    }
}
