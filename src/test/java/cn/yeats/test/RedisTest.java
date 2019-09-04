package cn.yeats.test;

import cn.yeats.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author: Feiyue
 * Date: 2019/9/4 18:03
 * Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    /*
    Redis有5种基本类型
        值类型： value  也就是string类型
        hash
        list
        set
        sorted set
     */

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest() {
        // 存
        redisTemplate.boundValueOps("name").set("John");
        // 设置过期时间
        redisTemplate.boundValueOps("name").expire(10, TimeUnit.SECONDS);
        // 取
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println("name:" + name);
    }

    @Test
    public void hashTest() {
        String bigKey = "user";
        redisTemplate.boundHashOps(bigKey).put("name", "Nick");
        redisTemplate.boundHashOps(bigKey).put("password", "111");
        String name = (String) redisTemplate.boundHashOps(bigKey).get("name");
        String password = (String) redisTemplate.boundHashOps(bigKey).get("password");

        System.out.println("name:" + name);
        System.out.println("password:" + password);
    }

    @Test
    public void listTest() {
        User user1 = new User();
        user1.setUsername("Susi");
        redisTemplate.boundListOps("list").leftPush(1);
        redisTemplate.boundListOps("list").leftPush("Micky");
        redisTemplate.boundListOps("list").leftPush(user1);
        List<Object> list = (List<Object>) redisTemplate.boundListOps("list").range(0, -1);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void setTest() {

    }

    @Test
    public void sortedSetTest() {

    }

    @Test
    public void delete() {
        String key = "name";
        redisTemplate.delete("key");
    }
}
