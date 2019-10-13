package com.zhf.service;

import com.zhf.bean.Administrator;
import com.zhf.bean.Student;

import java.util.ArrayList;
import java.util.Map;

public interface IStudentService {
    public boolean exists(String username);
    public boolean checkPwd(String username,String password);
    public boolean addStudent(Student student); //用于注册新学生
    Student studentSelectOne(String username,String password);
    public boolean updateOwnInfo(Student student, String name, char sex, int age);
    public boolean optCourse(String userName,String passWord,String course);
    public ArrayList<String> showSubjects(String username,String password);
    public Map<String,Double> scanSubjectScore(String userName, String passWord);
}
