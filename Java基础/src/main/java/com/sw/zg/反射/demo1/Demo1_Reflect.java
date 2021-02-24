package com.sw.zg.反射.demo1;

public class Demo1_Reflect {

    public static void main(String[] args) throws ClassNotFoundException {
        getClasss();
        //getStringFS();
    }

    //证明三个Class都是一个对象
    public static void getClasss() throws ClassNotFoundException {
        Class clazz1 = Class.forName("com.反射机制.demo1.Person");
        Class clazz2 = Person.class;

        Person p = new Person();
        Class clazz3 = p.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
    }

    //String 类的反射
    public static void getStringFS() {
        String name = "Huanglinqing";
        Class c1 = name.getClass();
        System.out.println(c1.getName());
    }
}
