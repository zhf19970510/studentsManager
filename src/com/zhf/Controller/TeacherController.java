package com.zhf.Controller;

import com.zhf.InitData.TeacherInit;
import com.zhf.bean.Student;
import com.zhf.bean.Teacher;
import com.zhf.service.ITeacherService;
import com.zhf.service.impl.TeacherServiceImpl;

import java.util.ArrayList;

public class TeacherController {
    private ITeacherService teacherService = TeacherServiceImpl.getTeacherService();

    private static TeacherController teacherController;

    private TeacherController(){

    }

    public static TeacherController getTeacherController(){
        if(teacherController==null){
            teacherController = new TeacherController();
        }
        return teacherController;
    }

    public boolean login(String t_username,String t_password){  //传入老师所对应的用户名和密码

        //判断该用户是否存在
        boolean exits = false;
        exits = teacherService.exists(t_username);

        boolean checkPwd = false;

        //验证该用户名对应的密码
        if(exits){
            checkPwd = teacherService.checkPwd(t_username,t_password);
            if(checkPwd){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean register(String name,int age,char sex,String subject,String username,String password) throws IllegalAccessException, InstantiationException {
        Teacher t = Teacher.class.newInstance();
        t.setName(name);
        t.setAge(age);
        t.setSex(sex);
        t.setSubject(subject);
        t.setUsername(username);
        t.setPassword(password);

        if(teacherService.addTeacher(t)){
            return true;
        }
        return false;
    }

    public boolean checkReUserName(String username){
        boolean exist = teacherService.exists(username);
        if(exist){
            return true;
        }
        return false;
    }

    public ArrayList<Student> showAllStudentInfo(String userName, String passWord) {
        ArrayList<Student> students = teacherService.showAllStudentInfo(userName, passWord);
        return students;
    }

    public Student findStudentByName(String name,String username,String password) {
        Student student = teacherService.findStudentByName(name, username, password);
        return student;
    }

    public boolean insertStudent(String name1, String userName, String passWord) {
        boolean isInsert = teacherService.insertStudent(name1, userName, passWord);
        return isInsert;
    }

    public boolean updateStudent(String name2, String userName, String passWord) {
        boolean isUpdate = teacherService.updateStudent(name2, userName, passWord);
        return isUpdate;
    }


    public boolean updateStudent1(String userName, String passWord, String name2, String name3, char sex, int age) {
        boolean isUpdate = teacherService.updateStudent1(userName, passWord, name2, name3, sex, age);
        return isUpdate;
    }

    public boolean deleteStudent(String name4, String userName, String passWord) {
        boolean isDelete = teacherService.deleteStudent(name4,userName,passWord);
        return isDelete;
    }

    public ArrayList<Student> scanStudentsOrder(String userName, String passWord) {
        ArrayList<Student> students = teacherService.scanStudentsOrder(userName, passWord);
        return students;
    }
}
