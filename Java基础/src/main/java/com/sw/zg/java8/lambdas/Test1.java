package com.sw.zg.java8.lambdas;

public class Test1 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("haha");
            }
        };
        r1.run();
    }
}
