package cn.yeats.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@Configuration // 声明当前类是Spring的配置类
public class JdbcConfig {

    /*
    @ConfigurationProperties(prefix = "jdbc")
        SpringBoot就会自动调用这个Bean（此处是DataSource）的set方法，然后完成注入
            使用的前提是：该类必须有对应属性的set方法！
     */
    @ConfigurationProperties(prefix = "jdbc")
    @Bean // 向Spring容器中注册Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
