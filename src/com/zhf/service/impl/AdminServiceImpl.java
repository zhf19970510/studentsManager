package com.zhf.service.impl;

import com.zhf.bean.Administrator;
import com.zhf.bean.Teacher;
import com.zhf.dao.AdmDao;
import com.zhf.dao.impl.AdmDaoImpl;
import com.zhf.service.IAdminService;

import java.util.ArrayList;

public class AdminServiceImpl implements IAdminService {
    private AdmDao adminDao = AdmDaoImpl.getAdmDao();
    private static AdminServiceImpl adminService;
    private AdminServiceImpl(){

    }
    public static IAdminService getAdminService(){
        if(adminService==null){
            adminService = new AdminServiceImpl();
        }
        return adminService;
    }


    @Override
    public boolean checkAdm(Administrator adminstrator) {
        //adminstrator
        //数据库保存的信息

        Administrator adm = adminDao.queryAdm(adminstrator.getAdmUserName());

        String ap1 = adminstrator.getAdmPassword();

        String ap2 = adm.getAdmPassword();

        if (ap1.equals(ap2)) {
            return true;
        }
        return false;
    }

    @Override
    public void insertAdm(Administrator adminstrator) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean exist(Administrator administrator) {
        Administrator queryAdm = adminDao.queryAdm(administrator.getAdmUserName());
        if (queryAdm!=null) {
            return true;
        }
        return false;
    }

    @Override
    public void delete(Administrator administrator) {
        // TODO Auto-generated method stub

    }

    @Override
    public Teacher selectOneTeacher(String name){
        Teacher teacher = adminDao.selectOneTeacher(name);
        return teacher;
    }

    @Override
    public ArrayList<Teacher> selectAllTeachers() {
        return adminDao.selectAllTeachers();
    }

    @Override
    public boolean addAvailableSubjects(String[] subjects) {
        if(adminDao.addAvailableSubjects(subjects)){
            return true;
        }
        return false;
    }

    @Override
    public boolean clearAvailableSubjects() {
        if(adminDao.clearAvailableSubjects()){
            return true;
        }
        return false;
    }

    @Override
    public boolean publishNews(String news) {

        if(adminDao.publishNews(news)){
            return true;
        }
        return false;
    }

}
