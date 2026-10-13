package com.sonnet.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration // 修饰类 标识当前是一个配置类 功能类似于applicationContext.xml
@ComponentScan(basePackages = "com.sonnet") // 开启包扫描 指定扫描com.sonnet包及其子包下面的类 功能类似于<context:component-scan>
public class SpringConfiguration {

    /**
     * @Bean 注解 它的功能类似于bean标签，修饰一个方法，方法的返回值就是我们需要管理的bean的类型
     * 在默认的情况下，如果我们不指定bean的名称，bean的名称就是方法的名称
     * 我们可以通过
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_lesson");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            return dataSource ;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Qualifier 可以修饰方法形参 意味着可以从IOC容器中获取指定的bean
     * @param dataSource
     * @return
     */
    @Bean (name = "runner")
    public QueryRunner runner(@Qualifier("dataSource") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }
}
