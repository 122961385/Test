package com.sw.zg.反射.demo3;

import java.lang.reflect.Constructor;

public class Demo3_Constructor {
    /**
     * Class类的newInstance()方法是使用该类无参的构造函数创建对象, 如果一个类没有无参的构造函数,
     * 就不能这样创建了,可以调用Class类的getConstructor
     * (String.class,int.class)方法获取一个指定的构造函数然后再调用Constructor类的newInstance
     * ("张三",20)方法创建对象
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.反射机制.demo3.Person");
        //Person p = (Person) clazz.newInstance();				通过无参构造创建对象
        //System.out.println(p);
        Constructor c = clazz.getConstructor(String.class,int.class);	//获取有参构造
        Person p = (Person) c.newInstance("张三",23);						//通过有参构造创建对象
        System.out.println(p);
    }
}
