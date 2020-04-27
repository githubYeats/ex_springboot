package cn.yeats.test;

import cn.yeats.model.User;
import cn.yeats.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fyyang
 * @date 2019/9/4 17:30
 * Desc: SpringBoot测试类
 */
@RunWith(SpringRunner.class) //指定新的运行器，由它来创建IoC容器
@SpringBootTest // 指定SpringBoot测试类
public class SpringBootTest1 {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void userServiceTest() {
        User user = userService.findById(3);
        System.out.println(user);
    }
}
