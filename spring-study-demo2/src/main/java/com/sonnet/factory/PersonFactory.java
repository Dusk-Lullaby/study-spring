package com.sonnet.factory;

import com.sonnet.dao.PersonDao;
import com.sonnet.dao.impl.PersonDaoImpl;

public class PersonFactory {

    // 定义一个方法，方法的返回值就是需要被管理的bean的类型
    public PersonDao getPerson() {
        return new PersonDaoImpl();
    }
}
