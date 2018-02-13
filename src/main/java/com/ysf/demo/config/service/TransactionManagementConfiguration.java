package com.ysf.demo.config.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * 事务配置
 * Create by yangshunfan
 * 2018/2/13 20:24
 */
@Configuration
//开启事务管理
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer{

    private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
