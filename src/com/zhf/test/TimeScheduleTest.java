package com.zhf.test;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimeScheduleTest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long date = System.currentTimeMillis();
        while (true) {
            System.out.println("请输入一个字符串");
            String s = sc.next();
            System.out.println("请输入一个字符串");
            String s2 = sc.next();
//            System.out.println("hello world\t" +);
            int x = 10;
            new Timer("time - " + 2).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run");
                }
            }, 5000,5000);

            System.out.println("**********end*******");
        }
    }
}
