package com.sw.zg.泛型;

import java.util.Random;

public class FruitGenerator2 implements Generator<String> {
    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
