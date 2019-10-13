package com.zhf.dao.impl;

import com.zhf.InitData.StudentInit;
import com.zhf.InitData.TeacherInit;
import com.zhf.bean.Student;
import com.zhf.bean.Teacher;
import com.zhf.dao.TeacherDao;

import java.util.*;
import java.util.stream.Stream;

public class TeacherDaoImpl implements TeacherDao {

    private static TeacherDaoImpl teacherDao;
    private TeacherDaoImpl(){

    }
    public static TeacherDao getTeacherDao(){
        if(teacherDao==null){
            teacherDao = new TeacherDaoImpl();
        }
        return teacherDao;
    }


    ArrayList<Teacher>teachers = TeacherInit.getTeacherList();

    @Override
    public Teacher queryUserName(String userName) {
        Teacher t = null;
        for(Teacher teacher:teachers){
            if(userName.equals(teacher.getUsername())){
                t = teacher;
                break;
            }
        }
        return t;
    }
    //用于注册学生信息
    @Override
    public boolean addTeacher(Teacher teacher) {
        TeacherInit ti = new TeacherInit();
        int len = TeacherInit.getTeacherList().size();
        int tId = Integer.parseInt(TeacherInit.getTeacherList().get(len-1).getTeacherId());
        int newtempId = tId+1;
        String tid="";
        if(newtempId<10){
            tid = "000"+newtempId;
        }else if(newtempId<100){
            tid = "00"+newtempId;
        }else if(newtempId<1000){
            tid = "0"+newtempId;
        }else{
            tid = ""+newtempId;
        }
        teacher.setTeacherId(tid);
        ti.addTeacher(teacher);
        int len1 = TeacherInit.getTeacherList().size();
        if(len1 == len+1) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Student> selectAllStudentInfo(String userName, String passWord) {
        for(Teacher teacher:teachers){
            if(userName.equals(teacher.getUsername())&&passWord.equals(teacher.getPassword())){
                ArrayList<Student> students = teacher.getStudents();
                return students;
            }
        }
        return null;
    }

    @Override
    public Student queryStudentByName(String name, String username, String password) {
        for (Teacher teacher : teachers) {
            if (username.equals(teacher.getUsername()) && password.equals(teacher.getPassword())) {
                ArrayList<Student> students = teacher.getStudents();
                for (Student student : students) {
                    if (name.equals(student.getName())) {
                        return student;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean insertStudent(String name1, String userName, String passWord) {
        Teacher teacher = queryUserName(userName);
        //记录是否已经包含该学生信息
        boolean flag = false;   //默认不包含
        if(passWord.equals(teacher.getPassword())){
            ArrayList<Student> students = teacher.getStudents();
            for(Student s:students){
                if(name1.equals(s.getName())){
                   flag = true;
                }
            }
            if(flag){
                return false;   //没有加入成功
            }else {
                //判断是否存在该名字对应的学生
                ArrayList<Student> students1 = StudentInit.getStudents();
                for(Student s:students1){
                    if(name1.equals(s.getName())){
                        teacher.addStudent(s);
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean updateStudent(String name2, String userName, String passWord){
        Teacher teacher = exists(userName,passWord);
        if(teacher!=null){
            ArrayList<Student> students = teacher.getStudents();
            for(Student s:students){
                if(name2.equals(s.getName())){
                    //有这个学生存在可以进行修改，先把这个信息反馈，然后再进行后续修改操作
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean updateStudent1(String userName, String passWord, String name2, String name3, char sex, int age) {
        Teacher teacher = exists(userName, passWord);
        if(teacher!=null){
            ArrayList<Student> students = teacher.getStudents();
            for(Student s:students){
                if(name2.equals(s.getName())){
                    s.setName(name3);
                    s.setAge(age);
                    s.setSex(sex);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String name4, String userName, String passWord) {
        Teacher teacher = exists(userName,passWord);
        if(teacher!=null){
            ArrayList<Student> students = teacher.getStudents();
            for(Student s:students){
                if(name4.equals(s.getName())){
                    students.remove(s);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<Student> scanStudentsOrder(String userName, String passWord) {
        Teacher teacher = exists(userName, passWord);
        if(teacher!=null){
            ArrayList<Student> students = teacher.getStudents();
            ArrayList<Student> students1 = new ArrayList<>(students);
            Collections.sort(students1, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    double o1AvgScore = o1.getAvgScore();
                    double o2AvgScore = o2.getAvgScore();
                    if((o1AvgScore-o2AvgScore)<0){
                        return 1;
                    }else if((o1AvgScore-o2AvgScore)>0){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });
            return students1;
        }
        return null;
    }

    public Teacher exists(String userName,String password){
        for(Teacher t:teachers){
            if(userName.equals(t.getUsername())&&password.equals(t.getPassword())){
                return t;
            }
        }
        return null;
    }


}
