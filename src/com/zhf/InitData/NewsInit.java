package com.zhf.InitData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NewsInit {
    private static ArrayList<String> newsArray = new ArrayList<>();
    static {
        try{
            File file1 = new File("src/initdata.txt");
            if((!file1.exists())||(file1.exists()&&file1.length()==0)) {
                File file = new File("src/news.txt");
                BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                String lines = "";
                while ((lines = bf.readLine()) != null) {
                    newsArray.add(lines);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getNews() {
        return newsArray;
    }

    public static void setNews(ArrayList<String> newsArray) {
        NewsInit.newsArray = newsArray;
    }

    public static void addNews(String news){
        newsArray.add(news);
    }

}
