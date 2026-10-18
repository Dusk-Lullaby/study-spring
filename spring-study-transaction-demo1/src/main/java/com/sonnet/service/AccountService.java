package com.sonnet.service;

public interface AccountService {

    // 转账的业务方法
    public void transfer(String sourceName, String targetName, double money);
}
