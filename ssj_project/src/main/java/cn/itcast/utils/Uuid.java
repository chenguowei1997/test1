package cn.itcast.utils;

import java.util.UUID;

/**
 * @Author: CGW
 * @Date: 2020/1/3 19:59
 */
/*获取唯一字符串工具类*/
public class Uuid {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
