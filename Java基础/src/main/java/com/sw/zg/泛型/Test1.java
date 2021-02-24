package com.sw.zg.泛型;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 也就是说Java中的泛型，只在编译阶段有效
 * 泛型有三种使用方式，分别为：泛型类、泛型接口、泛型方法
 */
//https://www.cnblogs.com/coprince/p/8603492.html
public class Test1 {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();//类型推断
//        list.add(78);
//        list.add(88);
//        list.add(77);
//        list.add(66);
//        //遍历方式一：
//        //for(Integer i : list){
//        //不需要强转
//        //System.out.println(i);
//        //}
//        //遍历方式二：
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        // 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
//        Generic<Integer> genericInteger = new Generic<>(123456);
//        System.out.println(genericInteger.getKey());
//        //传入的实参类型需与泛型的类型参数类型相同，即为String.
//        Generic<String> genericString = new Generic<>("key_vlaue");
//        System.out.println( "key is " + genericInteger.getKey());
//        System.out.println( "key is " + genericString.getKey());
//       Generic generic1 = new Generic(4444);
//        System.out.println(generic1.getKey());
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        gNumber.getKey(2);
        showKeyValue(gInteger);
    }


    public static void showKeyValue(Generic<?> obj){
    }
}
