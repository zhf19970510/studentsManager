package com.zhf.InitData;

import com.zhf.bean.Student;
import com.zhf.bean.Teacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TeacherInit {
    private static ArrayList<Teacher>teacherList = new ArrayList<>();
    //数据初始化工作
    static {
        try {
            File file1 = new File("src/initdata.txt");
            if((!file1.exists())||(file1.exists()&&file1.length()==0)) {
                File file = new File("src/teacher.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                String s = "";
                ArrayList<Teacher> teachers = new ArrayList<>();
                Teacher teacher;
                ArrayList<Student> students = StudentInit.getStudentsOrg();
                while ((s = br.readLine()) != null) {
//                System.out.println(s);
                    String[] strs = s.split(",");
                    teacher = new Teacher(strs[0], strs[1], strs[2].charAt(0), Integer.parseInt(strs[3]), strs[4], strs[5], strs[6]);
                    //TODO 还需要初始化每个老师对应的学生有哪些,默认初始化的学生都是老师的学生
                    teacher.setStudents(students);
                    teachers.add(teacher);
                }
                teacherList = teachers;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public static void setTeacherList(ArrayList<Teacher> teacherList) {
        TeacherInit.teacherList = teacherList;
    }

    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }



}
