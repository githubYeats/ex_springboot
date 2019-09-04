package cn.yeats.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Author: Feiyue
 * Date: 2019/9/4 12:21
 * Desc: 数据源配置类     加 @Configuration 注解，才会成为Spring的配置类
 */
@Configuration
@EnableConfigurationProperties(JdbcProperties.class) //声明要使用 JdbcProperties 这个类的对象
public class JdbcConfig {

    /*
    将JdbcProperties对象注入进来，有3种方式
        @Autowired
        有参构造器注入
        带@Bean的方法注入
     */

    /*
    向Spring容器中注册Bean
     */
    @Bean
    public DataSource dataSource(JdbcProperties jdbc) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        dataSource.setUrl(jdbc.getUrl());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setPassword(jdbc.getPassword());
        return dataSource;
    }
}
