package cn.yeats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Feiyue
 * Date: 2019/9/4 11:17
 * Desc:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")   // 请求路径：http://localhost:8080/hello
    public String hello() {
        return "Hello, Spring Boot.";
    }
}

