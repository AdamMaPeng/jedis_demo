package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 11:55
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 *  使用 Jedis 测试 redis 中的 Zset 结构
 *      zadd
 *      zrank
 *      zcount
 *      zrange
 *      zrangebyscore
 *      zrevrange
 *      zrem
 *      zincr
 *
 */
public class Jedis_Zset_Test {
    public static void main(String[] args) {
        // redis 服务器连接
        Jedis jedis  = new Jedis("hadoop102", 6379);

        // zadd
        Map<String, Double> scoreMembers = new HashMap();
        scoreMembers.put("Adam", new Double(95));
        scoreMembers.put("Bdam", new Double(89));
        scoreMembers.put("Cdam", new Double(99));
        scoreMembers.put("Ddam", new Double(110));
        scoreMembers.put("Edam", new Double(89));

        jedis.zadd("examScore",scoreMembers);

        // zrange
        System.out.println(jedis.zrange("examScore", 0, 100));

        // zrevrange
        System.out.println(jedis.zrevrange("examScore", 0, 100));

        // zrangeByScore
        System.out.println(jedis.zrangeByScore("examScore", 0, 150));

        // zrevrangeByScore
        System.out.println(jedis.zrevrangeByScore("examScore", 150, 0));

        // zincr
        jedis.zincrby("examScore",10,"Adam");

        // zrank
        System.out.println(jedis.zrank("examScore", "Adam"));

        // zcount
        System.out.println(jedis.zcount("examScore", 0, 150));

        // zrem
        System.out.println(jedis.zrem("examScore", "Adam"));


        // redis 服务器关闭
        jedis.close();
    }
}
