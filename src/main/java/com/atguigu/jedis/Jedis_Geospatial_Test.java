package com.atguigu.jedis;

/**
 * @author Adam-Ma
 * @date 2022/4/13 14:37
 * @Project jedis_demo
 * @email Adam_Ma520@outlook.com
 * @phone 18852895353
 */

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 *  使用 Jedis 完成  Geospatial 数据类型
 *      geoadd
 *      geopos
 *      geodist
 *      georadius
 *
 */
public class Jedis_Geospatial_Test {
    public static void main(String[] args) {
        // redis 服务器开启
        Jedis jedis = new Jedis("hadoop102", 6379);

        // geoadd
        Map<String, GeoCoordinate> memberCoordinateMap = new HashMap();
        memberCoordinateMap.put("ShangHai",new GeoCoordinate(127,87));
        memberCoordinateMap.put("NhangHai",new GeoCoordinate(124,47));
        memberCoordinateMap.put("ZhangHai",new GeoCoordinate(125,67));
        memberCoordinateMap.put("WhangHai",new GeoCoordinate(122,88));

        jedis.geoadd("China:city",memberCoordinateMap);

        // geodist
        System.out.println(jedis.geodist("China:city", "ShangHai", "ZhangHai"));

        // geopos
        System.out.println(jedis.geopos("China:city", "Shanghai"));

        // georadius
        System.out.println(jedis.georadius("China:city", 120, 30, 1000, GeoUnit.KM));

        // redis 服务器关闭
        jedis.close();
    }
}
