package com.zhf.dao.impl;

import com.zhf.InitData.AdminInit;
import com.zhf.InitData.AvaliableSubjectInit;
import com.zhf.InitData.NewsInit;
import com.zhf.InitData.TeacherInit;
import com.zhf.bean.Administrator;
import com.zhf.bean.Teacher;
import com.zhf.dao.AdmDao;

import java.util.ArrayList;
import java.util.Map;

public class AdmDaoImpl implements AdmDao {

    private static AdmDaoImpl admDao;
    private ArrayList<Teacher>teachers = TeacherInit.getTeacherList();
    private AdmDaoImpl(){

    }

    public static AdmDao getAdmDao(){
        if(admDao == null){
            admDao = new AdmDaoImpl();
        }
        return admDao;
    }

    Map<String, Administrator> adminMap = AdminInit.getAdminMap();
    @Override
    public Administrator queryAdm(String adminName) {
        return adminMap.get(adminName);
    }

    @Override
    public Teacher selectOneTeacher(String name){
        for(Teacher t:teachers){
            if(name.equals(t.getName())){
                return t;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Teacher> selectAllTeachers() {
        return teachers;
    }
    //获取
    @Override
    public boolean addAvailableSubjects(String[] subjects) {
        for(int i = 0;i<subjects.length;i++){
            AvaliableSubjectInit.addSubject(subjects[i]);
        }
        if(AvaliableSubjectInit.getAvaliable_subjects().size()==subjects.length){
            return true;
        }
        return false;
    }

    @Override
    public boolean clearAvailableSubjects() {
        AvaliableSubjectInit.clearAvaliableSubjects();
        if(AvaliableSubjectInit.getAvaliable_subjects().size()==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean publishNews(String news){
        ArrayList<String> news1 = NewsInit.getNews();
        int orSize = news1.size();
        news1.add(news);
        int newSize = news1.size();
        if(orSize+1 == newSize){
            return true;
        }
        return false;
    }

}
