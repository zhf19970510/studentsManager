package com.zhf.test;

import com.zhf.bean.Teacher;

import java.io.*;
import java.util.ArrayList;

public class TeacherInfoFromFile {
    public static void main(String[] args) throws Exception {
        File file = new File("src/teacher.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream,"utf-8"));
        String s  = "";
        ArrayList<Teacher> teachers = new ArrayList<>();
        Teacher teacher;
        while ((s=br.readLine())!=null){
            System.out.println(s);
            String[] strs = s.split(",");
            teacher = new Teacher(strs[0],strs[1],strs[2].charAt(0),Integer.parseInt(strs[3]),strs[4],strs[5],strs[6]);
            //TODO 还需要初始化每个老师对应的学生有哪些,默认初始化的学生都是老师的学生

            teachers.add(teacher);
        }
        for(Teacher t:teachers){
            System.out.println(t);
        }
    }
}
