package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 10:38
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ListPosition;

/**
 *  测试 Jedis 中的 List 数据类型
 *      lpush/rpush
 *      lpop / rpop
 *      rpoplpush
 *
 *      lindex
 *      linsert
 *      lset
 *      lrem
 *      llen
 *      lrange
 *
 */
public class Jedis_List_Test {
    public static void main(String[] args) {
        // 连接 redis 服务端
        Jedis jedis = new Jedis("hadoop102", 6379);

        /**
         *  测试 redis 中的 List 数据类型
         */
        // lpush
        jedis.lpush("phone","iphone","huawei","mi","vivo","oppo");
        // lrange
        System.out.println(jedis.lrange("phone", 0, -1));

        // rpop
        System.out.println(jedis.rpop("phone"));

        // lindex
        System.out.println(jedis.lindex("phone", 2));

        // linsert
        jedis.linsert("phone", ListPosition.AFTER,"oppo", "AAAA");

        // lset
        jedis.lset("phone", 1,"BBBB");

        // llen
        System.out.println(jedis.llen("phone"));

        // lrem
        jedis.lrem("phone",2,"vivo");

        // rpoplpush
        jedis.rpoplpush("phone","newPhone");

        // lrange
        jedis.lrange("phone", 0, -1);

        // 关闭 redis 连接
        jedis.close();
    }
}
