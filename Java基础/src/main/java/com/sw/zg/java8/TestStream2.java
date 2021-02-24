package com.sw.zg.java8;

//Stream的中间操作


import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class TestStream2 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "你六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1(){
        Stream<Employee> stream = emps.stream()
                .filter((e)-> {
                    System.out.println("streamAPI的中间操作");
                    return e.getAge()>20;
                });
        System.out.println("--------------------");
        stream.forEach(x -> {
            System.out.println(x);
            System.out.println("hahaha");
            int a = 100;
            System.out.println(a);
        });
    }


    @Test
    public void test11(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("aa","aaa");
        map.put("bb","bbb");
        map.put("cc","ccc");
        list.add(map);

        Stream<Map<String, String>> mapStream = list.stream().limit(1);
        mapStream.forEach(x->{
            System.out.println(x.toString());
        });


    }

    //map用法
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aaa","bbb","ccc");

        list.stream()
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);
        System.out.println("--------------");
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void testpx(){
        String a = "bbb";
        String b = "aaa";
        int i = a.compareTo(b);
        System.out.println(i);
    }
    
    //排序

    /**
     * sorted  自然排序（comparable）
     * sorted(Compartor com) 定制排序
     * https://blog.csdn.net/IT_10/article/details/104747173
     */
    @Test
    public void test3(){
        List<String> list = Arrays.asList("ddd","aaa","eee","ccc");
        list.stream().sorted()
                .forEach(System.out::println);
        System.out.println("--------------");

        emps.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge()==e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        if(e1.getAge()>e2.getAge()){
                            return 1;
                        }else{
                            return -1;
                        }
                    }
                }).forEach(System.out::println);
    }

    //归约
    @Test
    public void test4(){

    }
}
