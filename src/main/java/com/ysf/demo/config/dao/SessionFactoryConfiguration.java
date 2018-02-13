package com.ysf.demo.config.dao;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * Create by yangshunfan
 * 2018/2/13 13:12
 */
@Configuration
public class SessionFactoryConfiguration {

    @Value("${mybatis_config_file}")
    private String mybatisConfig;
    @Value("${mapper_path}")
    private String mapperPath;
    @Value("${entity_package}")
    private String entityPackage;
    @Autowired
    //@Qualifier("dataSource")
    private DataSource dataSource;


    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws PropertyAccessException, IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfig));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        //设置dataSource
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置映射实体类，指定实体类的扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
