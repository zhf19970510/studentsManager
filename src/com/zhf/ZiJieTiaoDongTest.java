package com.zhf;

import sun.nio.cs.FastCharsetProvider;

import java.util.*;

public class ZiJieTiaoDongTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Set<Integer>> list = new ArrayList<>();
        int sum = 0;
        int [][]arr = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Set<Integer> oldSet = new HashSet<>();
        for(int i = 1;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0;j<i;j++){
                if(arr[i][j]>3){
                    set.add(i);
                    set.add(j);
                }
            }
            int size = set.size();
            if(i==1){
                if(size!=0){
                    list.add(set);
                    sum += size;
                }
            }else {
                Set<Integer> set1 = new HashSet<>(set);
                boolean flag = false;
                if(size!=0) {
                    for (int k = 0; k < list.size(); k++) {
                        boolean b = set.retainAll(list.get(k));
                        if (set.size() < size) {
                            list.get(k).addAll(set1);
                            sum += set.size();
                            flag = true;
                        }
                    }
                    if(flag== false) {
                        list.add(set1);
                        sum+=set1.size();

                    }
                }
            }
        }

        int total = n-sum+list.size();
        System.out.println(total);

    }
}
