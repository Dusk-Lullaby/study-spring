package com.sonnet;

import com.sonnet.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class TestAspectJ {

    @Autowired
    UserService userService;

    @Test
    public void test01() {
        userService.deleteUser();
    }

    @Test
    public void test02() {
        userService.findAll();
    }

    @Test
    public void test03() {
        userService.updateUser();
    }

    @Test
    public void test04() {
        userService.addUser();
    }
}
