package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 10:53
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

/**
 *  redis 中的 key 的操作
 *    set
 *    get
 *
 *    exists
 *    type
 *    expire
 *    ttl
 *
 *    del
 *    unlink
 *
 *    dbsize
 *    flushdb
 *    flushall
 *
 *    keys *
 */
public class Jedis_Key_Test {
    public static void main(String[] args) {
        // redis 服务器连接
        Jedis jedis = new Jedis("hadoop102", 6379);

        // set
        jedis.set("setKey", "aaaaaa");

        // get
        System.out.println(jedis.get("setKey"));

        // exists
        System.out.println(jedis.exists("setKey"));

        // expire
        jedis.expire("setKey", 60);

        // ttl
        System.out.println(jedis.ttl("setKey"));

        // del
        jedis.del("setKey");

        // unlink
        jedis.unlink("s1");

        // dbsize
        System.out.println(jedis.dbSize());

        // flushDB
//        jedis.flushDB();
        // flushAll
//        jedis.flushAll();

        // redis 环境关闭
        jedis.close();
    }
}
