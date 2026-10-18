package com.sonnet.rowmapper;

import com.sonnet.pojo.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double money = resultSet.getDouble("money");
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return account;
    }
}
