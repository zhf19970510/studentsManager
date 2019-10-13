package com.zhf.InitData;

import java.util.ArrayList;

public class AvaliableSubjectInit {
    public static ArrayList<String> avaliable_subjects = new ArrayList<>();

    public static void addSubject(String subject){
        avaliable_subjects.add(subject);
    }

    public static ArrayList<String> getAvaliable_subjects(){
        return avaliable_subjects;
    }

    public static void setAvaliable_subjects(ArrayList<String> avaliable_subjects) {
        AvaliableSubjectInit.avaliable_subjects = avaliable_subjects;
    }

    public static void clearAvaliableSubjects(){
        avaliable_subjects = new ArrayList<>();
    }

}
