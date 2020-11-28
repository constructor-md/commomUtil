package com.prepare.utils.utils;

import java.util.UUID;

/**
 * UUID生成和处理
 */
public class UUIDUtils {


    public static String getUUID (){
        //replace方法将指定字符串替换，并返回一个新的字符串
        return UUID.randomUUID().toString().replace("-","");
    }
}
