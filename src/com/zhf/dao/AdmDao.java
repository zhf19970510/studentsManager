package com.zhf.dao;

import com.zhf.bean.Administrator;
import com.zhf.bean.Teacher;

import java.util.ArrayList;

public interface AdmDao {
    Administrator queryAdm(String adminName);
    Teacher selectOneTeacher(String name);
    ArrayList<Teacher> selectAllTeachers();
    public boolean addAvailableSubjects(String[] subjects);
    public boolean clearAvailableSubjects();
    public boolean publishNews(String news);
}
