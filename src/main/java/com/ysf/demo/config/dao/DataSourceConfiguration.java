package com.ysf.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Create by yangshunfan
 * 2018/2/13 12:58
 */
@Configuration
//配置mybatis的mapper的扫描路径
@MapperScan("com.ysf.demo.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String URL;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(jdbcDriver);
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //关闭连接后不自动commit
        comboPooledDataSource.setAutoCommitOnClose(false);
        return comboPooledDataSource;
    }
}
