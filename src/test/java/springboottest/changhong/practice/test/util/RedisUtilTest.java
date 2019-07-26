package springboottest.changhong.practice.test.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboottest.changhong.practice.test.pojo.DO.Cat;


/**
 * @Author: DoremiTiny
 * Create at: 2019/7/25 14:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void get() {
    }

    @Test
    public void set() throws InterruptedException {
//        String key = "key";
//        int value = 123456;
        Cat cat = Cat.of(1,"Tom",2);
//        System.out.println(redisUtil.set(key,value));
//        System.out.println(redisUtil.get(key ,int.class));
        System.out.println(redisUtil.set("cat",cat));
        System.out.println(redisUtil.get("cat",Cat.class));
    }
}