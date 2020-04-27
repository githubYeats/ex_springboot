package cn.yeats.service;

import cn.yeats.mapper.UserMapper;
import cn.yeats.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feiyue
 * @since 2019/9/4 15:30
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserMapper userMapper;

    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = RuntimeException.class)
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
