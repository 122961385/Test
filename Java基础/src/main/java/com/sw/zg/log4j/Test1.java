package com.sw.zg.log4j;

import org.apache.log4j.Logger;
//https://www.cnblogs.com/z-x-p/p/11527248.html
public class Test1 {

    static Logger logger = Logger.getLogger(Test1.class); //LogDemo为相关的类

    public static void main(String[] args) {
        logger.info("dssd");
    }
}
