package com.sw.zg.java8;

public class Test1 {
    public static void main(String[] args) {
        aaa("a","b");
    }

    public static void aaa(String ...bb){
        System.out.println(bb[0]);
    }
}

class TransferTest3 {
   public static void main(String args[]) {
       TransferTest3 test = new TransferTest3();
       test.first();
   }
   public void first() {
       int i = 5;
       Value v = new Value();
       v.i = 25;
       second(v, i);
       System.out.println(v.i);
   }
   public void second(Value v, int i) {
       i = 0;
       v.i = 20;
       Value val = new Value();
       v = val;
       System.out.println(v.i + " " + i);
   } }

class Value {
    int i = 15;
}

class Animal{
public void eat(){
    System.out.println("动物吃");
}
}

class Cat extends Animal {
    public void eat(){
        System.out.println("cat吃");
    }
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
    }
}

interface Person{
    public abstract void zq();
}

class Student implements Person {

    @Override
    public void zq() {
        System.out.println("zql");
    }
    public void hq() {
        System.out.println("hql");
    }

    public static void main(String[] args) {
        Person student = new Student();
        student.zq();
    }
}