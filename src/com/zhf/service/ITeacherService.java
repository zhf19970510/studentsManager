package com.zhf.service;

import com.zhf.bean.Student;
import com.zhf.bean.Teacher;

import java.util.ArrayList;

public interface ITeacherService {
    public boolean exists(String t_username);
    public boolean checkPwd(String t_username,String t_pwd);

    public boolean addTeacher(Teacher teacher); //用于注册学生信息
    //查找所有学生信息
    public ArrayList<Student> showAllStudentInfo(String userName, String passWord);
    //查找所有学员信息
    public Student findStudentByName(String name,String username,String password);
    //以单个学生名字添加学生信息
    public boolean insertStudent(String name1, String userName, String passWord);

    public boolean updateStudent(String name2, String userName, String passWord);

    public boolean updateStudent1(String userName, String passWord, String name2, String name3, char sex, int age);

    public boolean deleteStudent(String name4, String userName, String passWord);

    public ArrayList<Student> scanStudentsOrder(String userName, String passWord);

}
