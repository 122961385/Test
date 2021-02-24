package com.sw.zg.基本语法;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Test1 {

    public static void main(String[] args) {
         String appId ="myapplicationid";
    }

    //https://www.cnblogs.com/fqh123/p/11979977.html
    char a;
    @Test
    public void test1(){
        //八大基本数据类型,double,float丢失精度问题,
        //编码解码
        float f = 1.2f;
        System.out.println(f);
        System.out.println("系统默认编码：" + System.getProperty("file.encoding")); //查询结果GBK
        System.out.println(a);
        String encode = "张刚";
        try {
            byte[] bytes = encode.getBytes("GBK");
            System.out.println(new String(bytes, "GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String str2 = 3.5f + "ww";
        System.out.println(str2);
        System.out .println(3+4+"Hello!");
    }
}
