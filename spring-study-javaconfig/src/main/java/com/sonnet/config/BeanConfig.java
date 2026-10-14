package com.sonnet.config;

import com.sonnet.pojo.ADataSource;
import com.sonnet.pojo.BRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
@ComponentScan(basePackages = {"com.sonnet"})
public class BeanConfig {

    @Bean
    public ADataSource aDataSource() {
        return new ADataSource();
    }

    @Bean
    public BRunner bRunner() {
        return new BRunner(aDataSource());
    }
}
