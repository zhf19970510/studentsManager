package com.zhf.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

    //一个老师对应多个学生，老师可以查看多个学生的相关信息
    private ArrayList<Student> stuList = new ArrayList<>();

    public StudentList() {
        this.stuList = new ArrayList<>();
    }

    public void add(Student student) {
        stuList.add(student);
    }

    public void addAll(List<Student> students) {
        stuList.addAll(students);
    }

    //该学生因为特殊情况，不在这个老师的班上了
    public void remove(Student student){
        stuList.remove(student);
    }

    //显示出所有的学生信息
    public void showAll(){
        stuList.stream().forEach(System.out::println);
    }



}
