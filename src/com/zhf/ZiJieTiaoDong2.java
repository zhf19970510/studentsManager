package com.zhf;

import java.util.Scanner;

public class ZiJieTiaoDong2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = deal(n);
        System.out.println(sum);
    }
    public static int deal(int n){
        if(n==2||n==0){
            return 1;
        }
        if(n==4){
            return 2;
        }
        if(n==6){
            return 5;
        }
        if(n==8){
            return 14;
        }
        int sum = 0;
        int tmp = n-2;
        int tmp1 = tmp/2;
        if(tmp1%2==1){
            for(int i = tmp;i>=tmp1;i-=2){
                sum+=2*deal(i)*deal(tmp-i)%1000000007;
            }
        }else{
            for(int i = tmp;i>tmp1;i-=2){
                sum+=2*deal(i)*deal(tmp-i)%1000000007;
            }
        }

        return sum;
    }

}
