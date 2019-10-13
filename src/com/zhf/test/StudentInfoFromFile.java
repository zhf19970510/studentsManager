package com.zhf.test;

import com.zhf.bean.Address;
import com.zhf.bean.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudentInfoFromFile {
    public static void main(String[] args) throws Exception {
        File file = new File("src/student.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(fileInputStream,"utf-8"));

        String lines = "";
        ArrayList<Student> students = new ArrayList<>();
        Student student;
        Address address = new Address();
        while((lines = bfr.readLine())!=null){
            //1006,李六,男,22,上海 上海 浦东,四,9,python 92|linux 84|mybatis
            String[] strs = lines.split(",");   //总共分为8部分
            //分解地址，用对象存储
            if(strs[4]!=null){
                String[]area = strs[4].split(" ");
                address = new Address(area[0],area[1],area[2]);
            }
            student = new Student(strs[0],strs[1],strs[2].charAt(0),Integer.parseInt(strs[3]),address);
            student.setGrade(strs[5]);
            student.setCls(strs[6]);
            //对和成绩部分进行分解，存入学生对象中
            String[]subScores = strs[7].split("[|]");
            for(String subScore:subScores){
                String[] subject_score = subScore.split(" ");
                student.addSubject(subject_score[0]);
                if(subject_score.length==2){
                    student.putSubjectScore(subject_score[0],Double.parseDouble(subject_score[1]));
                }
            }
            student.setUsername(strs[8]);
            student.setPassword(strs[9]);
            students.add(student);
        }
        for(Student student1:students){
            System.out.println(student1);
            System.out.println(student1.getUsername());
            System.out.println(student1.getPassword());
        }

    }
}
