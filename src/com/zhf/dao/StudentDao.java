package com.zhf.dao;

import com.zhf.bean.Student;
import com.zhf.bean.Teacher;

import java.util.ArrayList;
import java.util.Map;

public interface StudentDao {
    public Student queryUserName(String userName);
    public boolean addStudent(Student student);//用于注册新学生
    //通过用户名和密码找到student信息，暂存student信息，进行后续操作
    public Student studentSelectOne(String username, String password);

    public boolean updateOwnInfo(Student student, String name, char sex, int age);

    public boolean optCourse(String userName,String passWord,String course);

    public ArrayList<String> showSubjects(String username,String password);

    public Map<String,Double> scanSubjectScore(String userName, String passWord);
}
