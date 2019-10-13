package com.zhf.Controller;

import com.zhf.InitData.StudentInit;
import com.zhf.bean.Administrator;
import com.zhf.bean.Student;
import com.zhf.bean.Teacher;
import com.zhf.service.IAdminService;
import com.zhf.service.impl.AdminServiceImpl;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;

public class AdminController {
    private IAdminService adminService = AdminServiceImpl.getAdminService();

    private static AdminController adminLoginController;

    private AdminController(){

    }

    //创建单例对象
    public static AdminController getAdminLoginController(){
        if(adminLoginController==null){
            adminLoginController=new AdminController();
        }
        return adminLoginController;
    }

    public boolean login(String adminUserName,String adminPassword){
        Administrator admin = new Administrator(adminUserName,adminPassword);
        //判断管理员是否存在
        boolean exist = false;
        exist = adminService.exist(admin);

        //验证管理员的密码
        boolean checkAdm = false;
        if(exist) {
            checkAdm = adminService.checkAdm(admin);
            if(checkAdm){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }

    public Teacher selectOneTeacher(String name){
        return adminService.selectOneTeacher(name);
    }

    public ArrayList<Teacher> selectAllTeacher(){
        return adminService.selectAllTeachers();
    }

    public boolean addAvailableSubjects(String[] subjects){
        if(adminService.addAvailableSubjects(subjects)){
            return true;
        }
        return false;
    }

    public boolean clearAvailableSubjects(){
        if(adminService.clearAvailableSubjects()){
            return true;
        }
        return false;
    }

    public boolean publishNews(String news) {
        if(adminService.publishNews(news)){
            return true;
        }
        return false;
    }
}