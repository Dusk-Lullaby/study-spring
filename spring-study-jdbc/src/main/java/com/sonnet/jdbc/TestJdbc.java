package com.sonnet.jdbc;

import com.sonnet.pojo.Account;

import java.sql.*;

public class TestJdbc {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 注册驱动
        //DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 准备连接数据库用到的用户名，密码，url
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/spring_lesson?useSSL=false&serverTimezone=Asia/Shanghai";
        // 获取连接对象
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from account";
        // 创建PreparedStatement对象， 预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Double money = resultSet.getDouble("money");
            Account account = new Account();
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            System.out.println(account);
        }
        // 关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
