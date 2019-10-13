package com.zhf.test;

import sun.rmi.log.LogInputStream;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String>list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("bdf");
        update(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void update(ArrayList<String>list){
        ArrayList<String> list1 = list;
        list1.add("mgf");
    }
}
