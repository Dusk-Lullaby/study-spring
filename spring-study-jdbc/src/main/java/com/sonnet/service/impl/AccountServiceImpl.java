package com.sonnet.service.impl;

import com.sonnet.dao.AccountDao;
import com.sonnet.dao.impl.AccountDaoImpl;
import com.sonnet.dao.impl.MybatisAccountDaoImpl;
import com.sonnet.factory.BeanFactory;
import com.sonnet.pojo.Account;
import com.sonnet.service.AccountService;

/**
 * 目前代码存在的问题：
 * 如果出现新的需求，程序中需要修改源代码才能实现
 * 明确概念：
 * 1. Bean：组件 在Java中指的是dao层，业务层的接口或者接口的实现
 * 2. JavaBean： 实体类，JavaBean并不完全等同于实体类，因为实体类只是组件的一部分
 * 3. 工厂： 创建JavaBean（创建dao 业务层 实现类的对象）
 * 解决方案：
 * 1. 通过一个配置文件来管理我们的dao接口实现类和业务类
 *      properties配置文件来管理 k=v 唯一标识=权限定名（包名+类名）
 * 2. 通过读取配置文件中的内容，获取v，基于反射的技术创建对象
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public void addAccount() {
        //AccountDao accountDao = new AccountDaoImpl();
        //AccountDao accountDao = new MybatisAccountDaoImpl();
        AccountDao accountDao = (AccountDao) BeanFactory.getBean("mybatisAccountDao");
        System.out.println(accountDao);
        accountDao.addAccount();
    }
}
