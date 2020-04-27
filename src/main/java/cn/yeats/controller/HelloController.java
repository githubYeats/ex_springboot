package cn.yeats.controller;

import cn.yeats.model.User;
import cn.yeats.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Feiyue
 * @since 2019/9/4 11:17
 * Desc:
 */
@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final UserServiceImpl userService;

    /**
     * 使用Restful风格，请求URL：http://localhost/hello/findUserById/1
     * @param id id
     * @return 响应
     */
    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable Integer id) {
        // SpringBoot整合通用Mapper的测试
        return userService.findById(id);
    }
}

