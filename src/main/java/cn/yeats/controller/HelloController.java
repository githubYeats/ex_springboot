package cn.yeats.controller;

import cn.yeats.model.User;
import cn.yeats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: Feiyue
 * Date: 2019/9/4 11:17
 * Desc:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private UserService userService;

    /**
     * 使用Restful风格，请求URL：http://localhost/hello/findUserById/1
     * @param id
     * @return
     */
    @GetMapping("/findUserById/{id}") // restful风格
    public User findUserById(@PathVariable Integer id) {
        // SpringBoot整合通用Mapper的测试
        return userService.findById(id);
    }
}

