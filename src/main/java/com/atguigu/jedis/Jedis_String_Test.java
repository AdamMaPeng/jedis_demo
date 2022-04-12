package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/12 21:38
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

/**
 *   通过 Jedis 测试 String 数据类型中的方法
 *      set
 *      get
 *      setnx
 *
 *      mset
 *      mget
 *      msetnx
 *
 *      append
 *      strlen
 *
 *      incr/decr
 *      incrby/decrby
 *
 */
public class Jedis_String_Test {
    public static void main(String[] args) {
        // 1、连接 redis 服务器
        Jedis jedis = new Jedis("hadoop102", 6379);

        // set
        String s1 = jedis.set("s1", "111");

        //get
        String s1get = jedis.get("s1");
        System.out.println(s1get);

        //setnx
        Long s2 = jedis.setnx("s2", "222");
        // get s2
        String s22 = jedis.get("s2");
        System.out.println(s22);

        //
        // 关闭 redis 服务器
        jedis.close();
    }
}
