package com.zhf.test;

import java.io.Serializable;

public class Cat extends Animal {
    private String name1;
    private String name2;

    public Cat(){

    }

    public Cat(String name,String type,String name1,String name2){
        super(name,type);
        this.name1 = name1;
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return /*"name=" +super.getName()+"\t"+
                "color="+super.getColor()+"\t"+*/
                super.toString()+
                "name1=" + name1 + "\t" +
                "name2=" + name2 + "\t"
                ;
    }
}
