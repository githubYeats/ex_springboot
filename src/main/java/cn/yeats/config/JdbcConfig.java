package cn.yeats.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
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
@PropertySource("classpath:jdbc.properties") // 加载外部配置文件
public class JdbcConfig {

    /*
    读取外部配置中的属性值
     */
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /*
    向Spring容器中注册Bean
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
