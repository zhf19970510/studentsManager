package com.zhf.test;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        int x = 1;
        while(true){
            System.out.println("helloworld");
            Scanner sc = new Scanner(System.in);
            sc.next();

            if(x == 1) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("考试啦");
                    }
                });
            }
            if(x==1) {
                executor.shutdown();
            }
            x++;

        }
    }
}
