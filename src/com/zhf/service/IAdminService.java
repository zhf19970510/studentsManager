package com.zhf.service;

import com.zhf.bean.Administrator;
import com.zhf.bean.Teacher;

import java.util.ArrayList;

public interface IAdminService {
    //判断管理员信息
    boolean checkAdm(Administrator adminstrator);

    //插入管理员信息
    void insertAdm(Administrator adminstrator);

    //判断管理员是否存在
    boolean exist(Administrator administrator);

    //删除管理员信息
    void delete(Administrator administrator);

    Teacher selectOneTeacher(String username);

    ArrayList<Teacher> selectAllTeachers();

    public boolean addAvailableSubjects(String[] subjects);

    public boolean clearAvailableSubjects();

    public boolean publishNews(String news);
}
