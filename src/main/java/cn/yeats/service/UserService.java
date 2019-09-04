package cn.yeats.service;

import cn.yeats.mapper.UserMapper;
import cn.yeats.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Feiyue
 * Date: 2019/9/4 15:30
 * Desc:
 */
@Service // Spring注解，注册Bean
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        User user = new User();
        // pojo中没有显式地写getter/setter方法，这是lombok的功效，它为pojo自动添加了。
        user.setUsername("John");
        return user;
    }

    @Transactional
    public void deleteUser(User User) {
        // 暂未整合MyBatis或通用Mapper，控制台打印以下内容测试用
        System.out.println("删除用户");
    }
}
