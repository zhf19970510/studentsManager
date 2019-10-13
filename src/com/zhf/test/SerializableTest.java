package com.zhf.test;

import java.io.*;
import java.util.ArrayList;

public class SerializableTest {
    public static void main(String[] args) throws Exception {
        Cat cat1 = new Cat("a","a","a","a");
        Cat cat2 = new Cat("b","b","b","b");
        Cat cat3 = new Cat("c","c","c,","c");
        Cat cat4 = new Cat("d","d","d","d");
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        /*File file = new File("src/cats1.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cat1);
        oos.writeObject(cat2);
        oos.writeObject(cat3);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Cat o =(Cat) ois.readObject();
        Cat o2 = (Cat) ois.readObject();
        Cat o3 = (Cat) ois.readObject();
        System.out.println(o);
        System.out.println(o2);
        System.out.println(o3);*/
        Student student = new Student("HAHAHA","F",32,"江西","吉安","永丰");
        Student student1 = new Student("fjdso","M",26,"江西","吉安","永丰");
        ArrayList<Student> students= new ArrayList<>();
        students.add(student);
        students.add(student1);
        /*ArrayList<Object>list = new ArrayList<>();
        list.add(cats);
        list.add(students);*/
        File f = new File("src/catsStudents.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(cats);
        oos.writeObject(students);
        oos.close();
        if(f.exists()&&f.length()!=0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            /*ArrayList<Object> cats1_students = (ArrayList<Object>)ois.readObject();
            for(Object o:cats1_students){
                //不能序列化
            }*/
            ArrayList<Cat> cats1 = (ArrayList<Cat>)ois.readObject();
            ArrayList<Student>students1 = (ArrayList<Student>)ois.readObject();
            for(Cat cat:cats1){
                System.out.println(cat);
            }
            for(Student student2:students1){
                System.out.println(student2);
            }
        }
    }
}
