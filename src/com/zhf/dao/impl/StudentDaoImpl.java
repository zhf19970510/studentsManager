package com.zhf.dao.impl;

import com.zhf.InitData.StudentInit;
import com.zhf.bean.Student;
import com.zhf.dao.StudentDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    private static StudentDaoImpl studentDao;

    private StudentDaoImpl(){

    }

    public static StudentDao getStudentDao(){
        if(studentDao == null){
            studentDao = new StudentDaoImpl();
        }
        return studentDao;
    }
    List<Student>students = StudentInit.getStudents();
    @Override
    public Student queryUserName(String userName) {
        for(Student s:students){
            if(s.getUsername().equals(userName)){
                return s;
            }
        }
        return null;
    }
    @Override
    public boolean addStudent(Student student){
        StudentInit si = new StudentInit();
        int len = StudentInit.getStudents().size();
        int stuId = Integer.parseInt(StudentInit.getStudents().get(len-1).getStuId());
        student.setStuId(String.valueOf(stuId+1));
        si.addStudents(student);
        int len1 = StudentInit.getStudents().size();
        if(len1==len+1){
            return true;
        }
        return false;
    }

    @Override
    public Student studentSelectOne(String username, String password) {
        Student student = queryUserName(username);
        if(student!=null){
            if(password.equals(student.getPassword())){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean updateOwnInfo(Student student, String name, char sex, int age) {
        for(Student student1:students){
            if(student==student1){
                student1.setName(name);
                student1.setSex(sex);
                student1.setAge(age);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean optCourse(String userName,String passWord,String course) {
//        AvaliableSubjectInit.addSubject(course);
        int or_size = 0;
        Student student = queryUserName(userName);
        if(passWord.equals(student.getPassword())){
            //从集合中找到对应的对象,并且对该对象进行改值操作
            or_size = student.getSubjects().size();
            for(Student s:StudentInit.getStudents()){
                if(s==student){
                    if(!s.getSubjects().contains(course)) {
                        s.addSubject(course);
                        student = s;
                    }
                }
            }
        }
        int new_size = student.getSubjects().size();
        if(or_size+1 == new_size){
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> showSubjects(String username,String password) {
        ArrayList<String> rs = new ArrayList<>();
        Student student = queryUserName(username);
        if(password.equals(student.getPassword())){
            ArrayList<String> subjects = student.getSubjects();
            rs = subjects;
        }
        return rs;
    }

    @Override
    public Map<String, Double> scanSubjectScore(String userName, String passWord) {
        Student student = queryUserName(userName);
        Map<String,Double>res = new HashMap<>();
        if(passWord.equals(student.getPassword())){
            for(Student t:StudentInit.getStudents()){
                if(student==t){
                    res = t.getSubScoreMap();
                    return res;
                }
            }
        }
        return null;
    }
}
