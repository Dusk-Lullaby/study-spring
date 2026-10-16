package com.sonnet.service;

public interface AccountService {

    // 转账的方法（转出人的姓名 转入人的姓名 转账金额）
    public void transfer(String sourceName, String targetName, Double money);
}
