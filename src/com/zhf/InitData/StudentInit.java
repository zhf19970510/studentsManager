package com.zhf.InitData;

import com.zhf.bean.Address;
import com.zhf.bean.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudentInit {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Student> studentsOrg = new ArrayList<>();
    static {
        try {
            File file1 = new File("src/initdata.txt");
            if((!file1.exists())||(file1.exists()&&file1.length()==0)) {
                File file = new File("src/student.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));

                String lines = "";
                Student student;
                Address address = new Address();
                while ((lines = bfr.readLine()) != null) {
                    //1006,李六,男,22,上海 上海 浦东,四,9,python 92|linux 84|mybatis
                    String[] strs = lines.split(",");   //总共分为8部分
                    //分解地址，用对象存储
                    if (strs[4] != null) {
                        String[] area = strs[4].split(" ");
                        address = new Address(area[0], area[1], area[2]);
                    }
                    student = new Student(strs[0], strs[1], strs[2].charAt(0), Integer.parseInt(strs[3]), address);
                    student.setGrade(strs[5]);
                    student.setCls(strs[6]);
                    //对和成绩部分进行分解，存入学生对象中
                    String[] subScores = strs[7].split("[|]");
                    for (String subScore : subScores) {
                        String[] subject_score = subScore.split(" ");
                        student.addSubject(subject_score[0]);
                        if (subject_score.length == 2) {
                            student.putSubjectScore(subject_score[0], Double.parseDouble(subject_score[1]));
                        }
                    }
                    student.setUsername(strs[8]);
                    student.setPassword(strs[9]);
                    students.add(student);
                    studentsOrg.add(student);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        StudentInit.students = students;
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public static ArrayList<Student> getStudentsOrg() {
        return studentsOrg;
    }
}
