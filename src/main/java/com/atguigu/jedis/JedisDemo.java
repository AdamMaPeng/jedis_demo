package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/12 21:34
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

/**
 *   测试 使用 Jedis 是否可以成功连接 到 redis
 */
public class JedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("hadoop102", 6379);

        String sname = jedis.set("name", "Adam");

        // 获取 name 的值
        String getName = jedis.get("name");

        System.out.println(getName);

        jedis.close();
    }
}
