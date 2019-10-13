package com.zhf.bean;


import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private String teacherId;                   //老师id
    private String username;                    //用户名
    private String password;                    //密码
    private ArrayList<Student>students;         //老师的学生列表
    public Teacher(){}
    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String subject;                     //老师教的科目
    public Teacher(String teacherId, String name, char sex, int age, String username,String password,String subject) {
        super(name, sex, age);
        this.teacherId = teacherId;
        this.username = username;
        this.password = password;
        this.subject = subject;
        students = new ArrayList<>();
    }

    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId){
        this.teacherId = teacherId;
    }
    public ArrayList<Student> getStudents() {
        if(students==null){
            students = new ArrayList<>();
        }
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public void setStudents(ArrayList<Student>studentList){
        this.students = studentList;
    }

    public String getSubject() {
        return subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //对该教师的所有学生进行展示
    public void showStudents(){
        System.out.println(super.getName()+"的学生有：");
        for (Student student:students){
            System.out.println(student.getName());
        }
    }

    @Override
    public String toString() {
        return  "teachid："+teacherId+"\t\t"+
                "姓名："+super.getName()+"\t"+
                "性别："+super.getSex()+"\t\t"+
                "年龄："+super.getAge()+"\t\t"+
                "所教科目：" + subject;
    }
}
