package com.zhf.service.impl;

import com.zhf.bean.Student;
import com.zhf.dao.StudentDao;
import com.zhf.dao.impl.StudentDaoImpl;
import com.zhf.service.IStudentService;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class StudentServiceImpl implements IStudentService{
    //    private AdmDao adminDao = AdmDaoImpl.getAdmDao();
    private StudentDao studentDao = StudentDaoImpl.getStudentDao();
    private static StudentServiceImpl stuenntService;
    private StudentServiceImpl(){

    }
    public static IStudentService getStudentService(){
        if(stuenntService==null){
            stuenntService = new StudentServiceImpl();
        }
        return stuenntService;
    }
    @Override
    public boolean exists(String username) {
        Student queryAdm = studentDao.queryUserName(username);
        if (queryAdm!=null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPwd(String username, String password) {
        Student s = null;
        s = studentDao.queryUserName(username);
        if(password.equals(s.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean addStudent(Student student){
        if(studentDao.addStudent(student)){
            return true;
        }
        return false;
    }

    @Override
    public Student studentSelectOne(String username, String password) {
        Student student = studentDao.studentSelectOne(username, password);
        return student;
    }

    @Override
    public boolean updateOwnInfo(Student student, String name, char sex, int age) {
        if(studentDao.updateOwnInfo(student,name,sex,age)){
            return true;
        }
        return false;
    }

    @Override
    public boolean optCourse(String userName,String passWord,String course) {
        if(studentDao.optCourse(userName,passWord,course)){
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> showSubjects(String username,String password) {
        ArrayList<String> subjects = studentDao.showSubjects(username,password);
        return subjects;
    }

    @Override
    public Map<String, Double> scanSubjectScore(String userName, String passWord) {
        Map<String, Double> subject_score = studentDao.scanSubjectScore(userName, passWord);
        return subject_score;
    }


}
