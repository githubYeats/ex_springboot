package cn.yeats.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Feiyue
 * Date: 2019/9/4 13:15
 * Desc: 外部配置文件属性读取类
 */

/*
如果一段属性只有一个Bean需要使用（比如这里的DataSource对象），
我们无需将其配置文件中各个属性注入到一个类。
直接在需要的地方声明即可。
    将下面JdbcProperties类上的注解写到JdbcConfig类中@Bean注解标记的方法上去就可以。
 */
//@ConfigurationProperties(prefix = "jdbc")
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
