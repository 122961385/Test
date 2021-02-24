package com.sw.zg.枚举;

public enum FlyType implements FlyAble {
    Bird("鸟") {
        @Override
        public void fly() {
            System.out.println("鸟用翅膀飞...");
        }

    },
    Plane("飞机") {
        @Override
        public void fly() {
            System.out.println("飞机用引擎飞...");
        }

    };
    private String name;

    private FlyType(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        System.out.println(this.name);
        return this.name;
    }
}
