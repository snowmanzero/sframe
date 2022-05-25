package com.zhang.sframe.zioc.test;

import com.zhang.sframe.zioc.context.SelfApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        SelfApplicationContext sac = new SelfApplicationContext(MainTest.class, args);
    }
}
