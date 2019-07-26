package springboottest.changhong.practice.test.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author: DoremiTiny
 * Create at: 2019/7/25 14:13
 */
@Component
public final class RedisUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key,long time){
        try{
            if (time > 0){
                redisTemplate.expire(key, time,TimeUnit.SECONDS );
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     * @param key
     * @return 秒 返回0代表永久有效
     */
    public long  getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key
     */
    public void delete(String... key){
        if (key != null && key.length > 0){
            if (key.length == 1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 对象缓存获取
     * @param key
     * @return
     */
    public <T> T get(String key,Class<T> clazz){
        try {
//            System.out.println(redisTemplate.opsForValue().get(key).getClass().getName().toString());
            return (T)redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            return null ;
        }
    }

    /**
     * 非对象类型获取
     * @param key
     * @return
     */
//    public String get(String key){
//        try {
//            return redisTemplate.opsForValue().get(key).toString();
//        }catch (Exception e){
//            return null ;
//        }
//    }
    /**
     * 普通缓存放入
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value){
        try {
            //任意类型转换成String
            String val = JSON.toJSONString(value);
            if(val==null||val.length()<=0){
                return false;
            }
            redisTemplate.opsForValue().set(key,val);
            return true;
        }catch (Exception e){
            return false;
        }
//        try {
//            redisTemplate.opsForValue().set(key, value);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
    }
    /**
     * 对象转字符串
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToString(T value) {

        if(value==null){
            return null;
        }
        Class clazz = value.getClass();
        if(clazz==int.class||clazz==Integer.class){
            return ""+value;
        }
        else if(clazz==long.class||clazz==Long.class){
            return ""+value;
        }
        else if(clazz==String.class){
            return (String)value;
        }else {
            return JSON.toJSONString(value);
        }
    }
}
