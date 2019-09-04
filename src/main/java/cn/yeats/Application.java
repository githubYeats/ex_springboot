package cn.yeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: Feiyue
 * Date: 2019/9/4 11:14
 * Desc: SpringBoot启动类  即SpringBoot项目的入口，一个SpringBoot项目只能有一个启动类。
 */
@SpringBootApplication // 有该注解标记的才是SpringBoot启动类
public class Application {
    public static void main(String[] args) {
        // 第1个参数，必须是SpringBoot启动类
        SpringApplication.run(Application.class, args);
    }
}
