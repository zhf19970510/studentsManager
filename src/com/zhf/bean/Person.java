package com.zhf.bean;

import java.io.Serializable;

/**
 * 普通人类
 * 包含姓名，性别，年龄三个属性
 *
 */
public abstract class Person implements Serializable {
    //姓名
    private String name;
    //性别
    private char sex;
    //年龄
    private int age;
    public Person(){}
    public Person(String name, char sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return  "姓名："+name+"\t"+
                "性别："+sex+"\t\t"+
                "年龄："+age+"\t\t";
    }
}
