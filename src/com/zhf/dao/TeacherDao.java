package com.zhf.dao;

import com.zhf.bean.Student;
import com.zhf.bean.Teacher;

import java.util.ArrayList;

public interface TeacherDao {
    public Teacher queryUserName(String userName);
    //用于注册学生信息
    public boolean addTeacher(Teacher teacher);
    //查找所有学生信息
    public ArrayList<Student> selectAllStudentInfo(String userName, String passWord);
    //以学生名字查找学生信息
    public Student queryStudentByName(String name, String username, String password);
    //以学生名字添加学生信息
    public boolean insertStudent(String name1, String userName, String passWord);

    public boolean updateStudent(String name2, String userName, String passWord);

    public boolean updateStudent1(String userName, String passWord, String name2, String name3, char sex, int age);

    public boolean deleteStudent(String name4, String userName, String passWord);

    public ArrayList<Student> scanStudentsOrder(String userName, String passWord);
}
