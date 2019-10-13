package com.zhf.test;

public class StaticTest1 {

    static {
        System.out.println("hello");
    }

    public static void test(){
        System.out.println("world");
    }


    public static void main(String[] args) {
        StaticTest1.test();
        StaticTest1.test();

        StaticTest1 st = new StaticTest1();

    }
}
