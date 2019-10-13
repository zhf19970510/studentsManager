package com.zhf.test;

public class staticTest {
    public static void test(){
        System.out.println(s);
    }

    public static String s = "abc";
    static {
        s = "def";
    }
    public static void main(String[] args) {
        test();
        System.out.println(s);
    }

}
