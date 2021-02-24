package cn.sw.controller;
import cn.sw.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    public static final String SUCCESS = "success";

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("testResis")
    public String testResis(){

        redisTemplate.opsForValue().set("mykey","狂神说");
        redisTemplate.opsForValue().set("mykey1","狂神说");

        Object mykey = redisTemplate.opsForValue().get("mykey");
        Object mykey1 = redisTemplate.opsForValue().get("mykey1");

        System.out.println(mykey);
        System.out.println(mykey1);
        return SUCCESS;
    }
}
