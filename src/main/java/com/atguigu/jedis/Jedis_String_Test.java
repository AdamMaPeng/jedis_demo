package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/12 21:38
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

import java.util.List;

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
        jedis.setnx("snx","234");
        System.out.println(jedis.get("snx"));

        // mset
        String mset = jedis.mset("ms1", "ms111", "ms2", "ms222");
        // mget
        List<String> mget = jedis.mget("ms1", "ms2");
        for (String s : mget) {
            System.out.println(s);
        }
        // msetnx
        Long msetnx = jedis.msetnx("msn1", "msn111", "msn2", "msn222");
        String msn1 = jedis.get("msn1");
        System.out.println(msn1);

        // append
        jedis.append("msn1", "--append");
        System.out.println(jedis.get("msn1"));

        // strlen
        System.out.println(jedis.strlen("msn1"));

        // incr
        jedis.incr("snx");
        System.out.println(jedis.get("snx"));

        //incrby
        jedis.incrBy("snx", 3);
        System.out.println(jedis.get("snx"));

        // decr
        jedis.decr("snx");
        System.out.println(jedis.get("snx"));

        // decrby
        jedis.decrBy("snx",3);
        System.out.println(jedis.get("snx"));

        // 关闭 redis 服务器
        jedis.close();
    }
}
