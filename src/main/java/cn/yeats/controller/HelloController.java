package cn.yeats.controller;

import cn.yeats.pojo.User;
import cn.yeats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Author: Feiyue
 * Date: 2019/9/4 11:17
 * Desc:
 */
@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    //----读取yml配置文件中的内容----
    @Value("${baidu.url}")
    private String baiduUrl;
    @Value("${google.url}")
    private String googleUrl;

    @GetMapping("/hello")   // 请求路径：http://localhost:8080/hello
    public String hello() {
        // 打印数据源到控制，打个断点，观察一下
        System.out.println("dataSource" + dataSource);

        // 多个yml配置文件的测试
        System.out.println(baiduUrl);
        System.out.println(googleUrl);

        // SpringBoot整合jdbc与事务的测试
        User user = userService.findById(1);
        String username = user.getUsername();
        System.out.println("username:" + username);
        userService.deleteUser(user);

        return "Hello, Spring Boot.";
    }
}

