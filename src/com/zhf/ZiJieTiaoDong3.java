package com.zhf;

import java.util.Scanner;

public class ZiJieTiaoDong3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        int[][]arr = new int[4][4];
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                arr[i][j]= scanner.nextInt();
            }
        }

        switch (d){
            case 1:
                for(int j=0;j<4;j++){
                    for(int i=0;i<3;i++){
                        if(arr[i][j]==arr[i+1][j]){
                            arr[i][j]=2*arr[i][j];
                            arr[i+1][j]=0;
                        }else{

                        }
                    }
                }
                break;
            case 2:
                for(int j=0;j<4;j++){
                    for(int i =3;i>0;i--){
                        if(arr[i][j]==arr[i-1][j]){
                            arr[i][j]=2*arr[i][j];
                            arr[i-1][j]=0;
                        }
                    }
                }
                break;
            case 3:
//                for()
                break;
            case 4:
                break;
        }


    }
}
