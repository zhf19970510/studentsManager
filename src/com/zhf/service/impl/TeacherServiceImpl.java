package com.zhf.service.impl;

import com.zhf.bean.Student;
import com.zhf.bean.Teacher;
import com.zhf.dao.TeacherDao;
import com.zhf.dao.impl.TeacherDaoImpl;
import com.zhf.service.ITeacherService;

import java.util.ArrayList;

public class TeacherServiceImpl implements ITeacherService {
    private TeacherDao teacherDao = TeacherDaoImpl.getTeacherDao();
    private static TeacherServiceImpl teacherService;
    private TeacherServiceImpl(){

    }
    public static TeacherServiceImpl getTeacherService(){
        if(teacherService==null){
            teacherService = new TeacherServiceImpl();
        }
        return teacherService;
    }

    @Override
    public boolean exists(String t_username) {
        Teacher t = null;
        t = teacherDao.queryUserName(t_username);
        if(t!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPwd(String t_username,String t_pwd) {
        Teacher t = null;
        t = teacherDao.queryUserName(t_username);
        if(t_pwd.equals(t.getPassword())){
            return true;
        }
        return false;
    }
    //用于注册学生信息
    @Override
    public boolean addTeacher(Teacher teacher) {
        if(teacherDao.addTeacher(teacher)){
            return true;
        }
        return false;
    }
    //查找所有学生信息
    @Override
    public ArrayList<Student> showAllStudentInfo(String userName, String passWord) {
        ArrayList<Student> students = teacherDao.selectAllStudentInfo(userName, passWord);
        return students;
    }

    @Override
    public Student findStudentByName(String name, String username, String password) {
        Student student = teacherDao.queryStudentByName(name, username, password);
        return student;
    }

    @Override
    public boolean insertStudent(String name1, String userName, String passWord) {
        boolean isInsert = teacherDao.insertStudent(name1, userName, passWord);
        return isInsert;
    }

    @Override
    public boolean updateStudent(String name2, String userName, String passWord) {
        boolean isUpdate = teacherDao.updateStudent(name2,userName,passWord);
        return isUpdate;
    }

    @Override
    public boolean updateStudent1(String userName, String passWord, String name2, String name3, char sex, int age) {
        boolean isUpdate = teacherDao.updateStudent1(userName, passWord, name2, name3, sex, age);

        return isUpdate;
    }

    @Override
    public boolean deleteStudent(String name4, String userName, String passWord) {
        boolean isDelete = teacherDao.deleteStudent(name4,userName,passWord);
        return isDelete;
    }

    @Override
    public ArrayList<Student> scanStudentsOrder(String userName, String passWord) {
        ArrayList<Student> students = teacherDao.scanStudentsOrder(userName, passWord);
        return students;
    }


}
