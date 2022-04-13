package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 11:29
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

/**
 *   redis  中 的 set 数据结构
 *      sadd
 *      smembers
 *      sismember
 *
 *      scard
 *      srem
 *      sinter
 *      sunion
 *      sdiff
 *
 *      spop
 *      smove
 *      srandmember
 */
public class Jedis_Set_Test {
    public static void main(String[] args) {
        // redis 服务器连接
        Jedis jedis = new Jedis("hadoop102", 6379);

        // sadd
        jedis.sadd("userPhone","ihone","vivo","oppo","huawei","mi","phone","mi");

        // smembers
        System.out.println(jedis.smembers("userPhone"));

        // sismember
        System.out.println(jedis.sismember("userPhone", "Lenovo"));

        // srandmember
        System.out.println(jedis.srandmember("userPhone"));

        // smove
        jedis.smove("userPhone","newUserPhone","mi");

        // spop
        System.out.println(jedis.spop("userPhone"));

        // sunion
        System.out.println(jedis.sunion("userPhone", "newUserPhone"));

        // sinter
        System.out.println(jedis.sinter("userPhone", "newUserPhone"));

        // sdiff
        System.out.println(jedis.sdiff("userPhone", "newUserPhone"));

        //srem
        System.out.println(jedis.srem("userPhone", "vivo"));

        // scard
        System.out.println(jedis.scard("userPhone"));

        // redis 环境关闭
        jedis.close();
    }
}
