package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 11:43
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 *  使用 jedis 测试 redis 中的 hash 数据结构
 *      hset
 *      hget
 *      hsetnx
 *
 *      hkeys
 *      hvals
 *      hincr
 *      hexists
 *      hmset
 */
public class Jedis_Hash_Test {
    public static void main(String[] args) {
        //redis 服务器连接
        Jedis jedis = new Jedis("hadoop102", 6379);

        // hset
        jedis.hset("user:10001","name","Sam");

        // hget
        System.out.println(jedis.hget("user:10001", "name"));

        // hmset
        Map<String, String> hashMap = new HashMap();
        hashMap.put("age","25");
        hashMap.put("addr","BeiJing");
        hashMap.put("hobby","Guiter");

        jedis.hmset("user:10001",hashMap);

        // hincr
        jedis.hincrBy("user:10001","age",2);

        // hexists
        System.out.println(jedis.hexists("user:10001", "sex"));

        // hkeys
        System.out.println(jedis.hkeys("user:10001"));

        // hvals
        System.out.println(jedis.hvals("user:10001"));

        // redis 关闭
        jedis.close();

    }
}
