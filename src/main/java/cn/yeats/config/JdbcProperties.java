package cn.yeats.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Feiyue
 * Date: 2019/9/4 13:15
 * Desc: 外部配置文件属性读取类
 */

/*
@ConfigurationProperties    声明当前类为属性读取类
prefix = "jdbc"     读取属性文件中，前缀为jdbc的值
 */
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {
    private String driverClassName;

    private String url;

    private String username;

    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
