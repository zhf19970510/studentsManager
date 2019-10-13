package com.zhf.bean;

import java.util.*;

/**
 * 学生类
 * 包括学号，姓名，性别，年龄，家庭地址，年级，班级，学科s，成绩属性
 *
 * */
public class Student extends Person{
    private String stuId;                   //学号
    private Address address;                //家庭地址
    private String grade;                   //年级
    private String cls;                     //班级

    public Student(){}
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

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public void setSubScoreMap(Map<String, Double> subScoreMap) {
        this.subScoreMap = subScoreMap;
    }

    private String username;                //用户名
    private String password;                //密码
    private ArrayList<String>subjects;     //所拥有的学科
    private Map<String,Double>subScoreMap; //学生每个学科所对应的成绩
    public Student(String stuId, String name, char sex, int age, Address address) {
        super(name,sex,age);
        this.stuId = stuId;
        this.address = address;
        subjects = new ArrayList<>();
        subScoreMap = new HashMap<>();
    }

    //增加科目
    public void addSubject(String subject){
        subjects.add(subject);
    }
    public void addSubjects(List<String>subjects){
        subjects.addAll(subjects);
    }


    //删除科目
    public void removeSubject(String subject){
        subjects.remove(subject);
    }

    //给学生对应科目添加所对应的成绩(需要考试后，并且有相应学科才会赋予成绩）
    public void putSubjectScore(String subject, double score){
        subScoreMap.put(subject,score);
    }


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public ArrayList<String> getSubjects() {
        if(subjects==null){
            subjects = new ArrayList<>();
        }
        return subjects;
    }

    public Map<String, Double> getSubScoreMap() {
        if(subScoreMap==null){
            subScoreMap = new HashMap<>();
        }
        return subScoreMap;
    }

    //对该学生的所有科目进行展示
    public void showSubjects(){
        System.out.println(super.getName()+"的课程有：");
        for(String subject:subjects){
            System.out.println(subject);
        }
    }

    //对该学生的已有的科目和成绩进行遍历输出
    public void showSubjectsAndScore(){
        Set<Map.Entry<String, Double>> entries = subScoreMap.entrySet();
        System.out.println("科目"+"\t\t"+"成绩");
        for(Map.Entry<String,Double>entry:entries){
            System.out.println(entry.getKey()+"\t\t"+entry.getValue());
        }
    }

    //计算平均分
    public double getAvgScore(){
        Set<Map.Entry<String, Double>> entries = subScoreMap.entrySet();
        double sum = 0;
        for(Map.Entry<String,Double>entry:entries){
            sum += entry.getValue();
        }
        return sum/subScoreMap.size();
    }

    @Override
    public String toString() {
        return  "学号：" + stuId + "\t"+
                super.toString()+
                "家庭住址：" + address +"\t\t"+
                "年级：" + grade + "\t\t" +
                "班级：" + cls ;
    }



}
