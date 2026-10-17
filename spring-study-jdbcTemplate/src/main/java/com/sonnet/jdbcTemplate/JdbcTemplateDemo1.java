package com.sonnet.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 目前代码存在的问题：
 *  1. 通过new的方法管理DriverManagerDataSource和 JdbcTemplate。我们使用Spring的IOC环境帮助我们管理
 *  2. 执行sql语句的时候，没有预编译sql语句的过程。直接将值注入容易造成sql语句注入的问题
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_lesson");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "insert into account(name, money) values ('wangwu', 300.0)";
        //String sql = "delete from account where name = 'wangwu'";
        jdbcTemplate.execute(sql);
    }
}
