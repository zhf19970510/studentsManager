package com.zhf.test;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String sex;
    private int age;
    private Address address;
    public Student() {
    }

    public Student(String name, String sex, int age,String provience,String city,String community) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        /*address.setProvince(provience);
        address.setCity(city);
        address.setCommunity(community);*/
        address = new  Address(provience,city,community);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
