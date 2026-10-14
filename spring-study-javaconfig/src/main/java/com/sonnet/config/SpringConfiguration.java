package com.sonnet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 修饰类 标识当前是一个配置类 功能类似于applicationContext.xml
@ComponentScan(basePackages = "com.sonnet") // 开启包扫描 指定扫描com.sonnet包及其子包下面的类 功能类似于<context:component-scan>
@Import(value = {DataSourceConfig.class}) // 导入注解，可以导入子配置类
public class SpringConfiguration {
}
