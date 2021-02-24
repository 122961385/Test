package com.sw.zg.java8;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;


public class TestLambda2 {

    /**
     * 语法格式1：无参数无返回值
     */
    @Test
    public void test1(){
        int num = 0;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World"+num);
            }
        };
        runnable.run();
        System.out.println("----------------------------");
        Runnable r1 = ()-> System.out.println("Hello Lambda");
        r1.run();
    }

    /**
     * 语法格式2：一个参数无返回值
     * 只有一个参数，小括号可以省略不写
     */
    @Test
    public void test2(){
        Consumer<String> con = x-> System.out.println(x);
        con.accept("张刚位于");


        Consumer<String> con2 = System.out::println;
        con2.accept("你好的");

    }

    /**
     * 语法格式3:有两个以上参数，有返回值，并且Lambda体有多条语句
     */
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y)->{
            System.out.println("haha");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(3,2));
    }

    /**
     * 语法格式4:若Lambda体中只有一条语句，return和大括号都可以省略不写
     */
    @Test
    public void test4(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        System.out.println(com.compare(3,2));
    }
    /**
     * 语法格式6：Lambda式中的参数列表可以省略不写
     */

    /**
     * 函数式接口：接口中只有一个抽象方法的接口
     */
    @Test
    public void test5(){
    Integer num = operation(100,(x)->x*x);
        System.out.println(num);
        System.out.println(operation(200,(x)->x*x));
    }

    public Integer operation(Integer num, MyFun fun){
        return fun.getValue(num);
    }

    @Test
    public void test6(){
        op(100L,200L,(x,y)->x+y);

    }

    public void op(Long l1,Long l2,MyFun2<Long,Long> myFun2){
        System.out.println(myFun2.getValue(l1,l2));
    }
}
