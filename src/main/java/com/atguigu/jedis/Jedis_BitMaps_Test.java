package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 14:12
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;

/**
 *  使用 Jedis 完成 BitMaps 功能
 *      setbit
 *      getbit
 *      bitop
 *      bitcount
 *
 */
public class Jedis_BitMaps_Test {
    public static void main(String[] args) {
        // redis 服务器开启
        Jedis jedis = new Jedis("hadoop102", 6379);

        // bitset
        jedis.setbit("userVisit",5,true);
        jedis.setbit("userVisit",9,true);
        jedis.setbit("userVisit",11,true);
        jedis.setbit("userVisit",19,true);

        // getBit
        System.out.println(jedis.getbit("userVisit", 5));

        // bitcount
        System.out.println(jedis.bitcount("userVisit"));

        // bitop
        jedis.bitop(BitOP.AND, "unique:user:20201106","userVisit");

        // redis 服务器关闭
        jedis.close();
    }
}
