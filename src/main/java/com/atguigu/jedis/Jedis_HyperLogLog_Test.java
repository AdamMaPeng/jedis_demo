package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 14:24
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.Jedis;

/**
 *  使用 Jedis 完成 HyperLogLog 数据结构的 完成
 *      pfadd
 *      pfcount
 *      pfmerge
 */
public class Jedis_HyperLogLog_Test {
    public static void main(String[] args) {
        // redis 服务器 开启
        Jedis jedis = new Jedis("hadoop102", 6379);

        // pfadd
        jedis.pfadd("PE","PP","FB","BB","SW","RUN","BB");

        // pfcount
        System.out.println(jedis.pfcount("PE"));

        // pfadd
        jedis.pfadd("Unit","TB","PB","EB","ZB","YB","BB","NB","DB");

        // pfmerge
        System.out.println(jedis.pfmerge("PE", "Unit"));
        // redis 服务器关闭
        jedis.close();
    }
}
