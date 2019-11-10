package cn.yeats.service;

import cn.yeats.mapper.UserMapper;
import cn.yeats.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Feiyue
 * Date: 2019/9/4 15:30
 * Desc:
 */
@Slf4j
@Service // Spring注解，注册Bean
public class UserService {

    /*
    这个地方会提示自动注入失败。这是编译检查，没检查到UserMapper类型的Bean。
    其实这是没有错的。

    原因：
        通用Mapper，是运行时，Spring框架为其生成代理实现类的。
        此时还没有运行，Spring容器中自然是没有UserMapper类型的Bean对象的。
     */
    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void deleteUser(User user) {
        user = userMapper.selectByPrimaryKey(7);
        userMapper.deleteByPrimaryKey(user);

        // 模拟出错，查看事务控制的效果: 删除用户的代码虽然执行，但用户数据是不会被删除的
        try {
            Thread.sleep(5000);
            //int x = 1 / 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
