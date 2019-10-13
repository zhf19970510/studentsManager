package com.zhf.Controller;

import com.zhf.bean.Student;
import com.zhf.service.IStudentService;
import com.zhf.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Map;

public class StudentController {
    private IStudentService studentService = StudentServiceImpl.getStudentService();

    private static StudentController studentController;

    private StudentController(){

    }

    public static StudentController getStudentController(){
        if(studentController==null){
            studentController = new StudentController();
        }
        return studentController;
    }

    public  Student studentSelectOne(String username,String password) {
        Student student = studentService.studentSelectOne(username, password);
        return student;
    }

    public boolean checkReUserName(String username){
        boolean exist = studentService.exists(username);
        if(exist){
            return true;
        }
        return false;
    }

    public boolean login(String t_userName, String t_password) {
        //判断该用户是否存在
        boolean exits = false;
        exits = studentService.exists(t_userName);
        boolean checkPwd = false;

        //验证该用户名对应的密码
        if(exits){
            checkPwd = studentService.checkPwd(t_userName,t_password);
            if(checkPwd){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean register(String name1, char sex1, int age1, String s_username, String password) {
        Student s = new Student();
        s.setName(name1);
        s.setSex(sex1);
        s.setAge(age1);
        s.setUsername(s_username);
        s.setPassword(password);
        if(studentService.addStudent(s)){
            return true;
        }
        return false;
    }

    public boolean updateOwnInfo(Student student, String name, char sex, int age) {
        if(studentService.updateOwnInfo(student,name,sex,age)){
            return true;
        }
        return false;
    }

    public boolean optCourse(String userName,String password,String course) {
        if(studentService.optCourse(userName,password,course)){
            return true;
        }
        return false;
    }

    public ArrayList<String> showSubjects(String username,String password) {

        ArrayList<String> subjects = studentService.showSubjects(username,password);
        return subjects;
    }

    public Map<String,Double> scanSubjectScore(String userName, String passWord) {
        Map<String, Double> subject_score = studentService.scanSubjectScore(userName, passWord);
        return subject_score;
    }


}
