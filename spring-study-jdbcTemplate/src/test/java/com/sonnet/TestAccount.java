package com.sonnet;

import com.sonnet.dao.AccountDao;
import com.sonnet.pojo.Account;
import com.sonnet.rowmapper.MyRowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * JdbcTemple 提供了两方法
 *      query方法：专门执行查询的方法
 *      update方法：专门执行更新的方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:applicationContext.xml"})
public class TestAccount {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库操作 -- 查询所有数据库
    @Test
    public void test01() {
        String sql = "select * from account";
        List<Account> accountList = jdbcTemplate.query(sql, new MyRowMapper());
        accountList.forEach(System.out::println);
    }

    // 查询数据库操作 -- 根据id查询
    @Test
    public void test02() {
        String sql = "select * from account where id = ?";
        System.out.println(jdbcTemplate.query(sql, new MyRowMapper(), 1).get(0));
    }

    // 聚合函数查询 -- 统计数据表中的记录
    @Test
    public void test03() {
        String sql = "select count(*) from account where id > ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, 2);
        System.out.println("总记录是" + count);
    }

    @Autowired
    AccountDao accountDao;

    @Test
    public void test04() {
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void test05() {
        Account account = new Account();
        account.setName("jiayi");
        account.setMoney(802.0);
        accountDao.addAccount(account);
    }

    @Test
    public void test06() {
        Account account = new Account();
        account.setId(3);
        account.setName("wangwu2");
        account.setMoney(1000.0);
        accountDao.updateAccount(account);
    }

    @Test
    public void test07() {
        accountDao.deleteAccount(9);
    }
}
