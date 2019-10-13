package com.zhf.InitData;

import com.zhf.bean.Administrator;

import java.util.HashMap;
import java.util.Map;

public class AdminInit {
    private static Map<String, Administrator> adminMap= new HashMap<String,Administrator>();
    static {
        adminMap.put("abc",new Administrator("abc","abc"));
        adminMap.put("zhf",new Administrator("zhf","zhf"));
        adminMap.put("yyy",new Administrator("yyy","yyy"));
    }

    public static Map<String, Administrator> getAdminMap() {
        return adminMap;
    }

    public static void setAdminMap(Map<String, Administrator> adminMap) {
        AdminInit.adminMap = adminMap;
    }
    public static void addAdmin(String adminUserName,Administrator administrator){
        adminMap.put(adminUserName,administrator);
    }

}
