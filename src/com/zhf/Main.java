package com.zhf;

import com.zhf.Controller.AdminController;
import com.zhf.Controller.StudentController;
import com.zhf.Controller.TeacherController;
import com.zhf.InitData.AvaliableSubjectInit;
import com.zhf.InitData.NewsInit;
import com.zhf.InitData.StudentInit;
import com.zhf.InitData.TeacherInit;
import com.zhf.bean.Student;
import com.zhf.bean.Teacher;

import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    AdminController adminController = AdminController.getAdminLoginController();
    TeacherController t_Controller = TeacherController.getTeacherController();
    StudentController s_Controller = StudentController.getStudentController();
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //加载数据
        File initFile = new File("src/initdata.txt");

        try {
            if(initFile.exists()&&initFile.length()>0) {
                FileInputStream fis = new FileInputStream(initFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                //可选课程、新闻列表、学生信息、老师信息
                ArrayList<String> avaliable_subjects = (ArrayList<String>) ois.readObject();
                ArrayList<String> newsArray = (ArrayList<String>) ois.readObject();
                ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
                ArrayList<Teacher> teachers = (ArrayList<Teacher>)ois.readObject();
                AvaliableSubjectInit.setAvaliable_subjects(avaliable_subjects);
                NewsInit.setNews(newsArray);
                StudentInit.setStudents(students);
                TeacherInit.setTeacherList(teachers);
                if(avaliable_subjects.size()!=0){
                    coursePermission = true;
                }
            }
        }catch (Exception e){
            System.out.println("加载初始文件失败!");
        }

        System.out.println("**************欢迎登入学生信息管理系统**************");
        Main main1 = new Main();
        while(true) {
            main1.LoginOrRegisterOrQuit();
        }
    }
    //管理员登录页面
    public void adminLogin() throws InstantiationException, IllegalAccessException {
        System.out.println("请输入管理员用户名：");
        String adminUserName = sc.next();
        System.out.println("请输入管理员密码：");
        String adminPassword = sc.next();
        boolean isLogin = adminController.login(adminUserName, adminPassword);
        if(isLogin){
            System.out.println("**************欢迎进入学生管理系统界面**************");
            manageTeachers();
        }else{
            System.out.println("用户名或密码错误，请重新输入或者请先注册账号");
            LoginOrRegisterOrQuit();
        }
    }
    //老师登录页面
    public void teacherLogin() throws InstantiationException, IllegalAccessException {
        System.out.println("****************欢迎老师登录**************");
        System.out.println("请输入您的用户名：");
        String t_UserName = sc.next();
        System.out.println("请输入您的密码：");
        String t_Password = sc.next();
        boolean isLogin = t_Controller.login(t_UserName, t_Password);
        if(isLogin){
            System.out.println("**************欢迎进入学生管理系统界面**************");
            teacherOwnManager(t_UserName,t_Password);

        }else{
            System.out.println("用户名或密码错误，请重新输入或者请先注册账号");
            LoginOrRegisterOrQuit();
        }
    }
    //学生登录页面
    private void studentLogin() throws InstantiationException, IllegalAccessException {
        System.out.println("****************欢迎学生登录**************");
        System.out.println("请输入您的用户名：");
        String s_UserName = sc.next();
        System.out.println("请输入您的密码：");
        String s_Password = sc.next();
        boolean isLogin = s_Controller.login(s_UserName, s_Password);
        if(isLogin){
            System.out.println("**************欢迎进入学生管理系统界面**************");
            studentOwnManager(s_UserName,s_Password);
        }else{
            System.out.println("用户名或密码错误，请重新输入或者请先注册账号");
            LoginOrRegisterOrQuit();
        }
    }
    //模拟登录、注册或退出功能
    public void LoginOrRegisterOrQuit() throws IllegalAccessException, InstantiationException {
        System.out.println("请选择你要进行的操作： 1.登录\t2.注册\t3.退出");
        try {
            int opt = Integer.parseInt(sc.next());
            if (opt < 1 || opt > 3) {
                System.out.println("没有该选项，请重新选择！");
                LoginOrRegisterOrQuit();
            } else {
                switch (opt) {
                    case 1:
                        optIdentity();
                        break;
                    case 2:
                        System.out.println("请选择您的身份：1.学生\t2.老师");
                        optRegister();
                        break;
                    case 3:
                        //对本次程序的结果进行存储，以方便下次直接启动系统获取已经进行操作过后的内容
                        //获取要存入集合中的对象
                        //选课中的可选课程
                        ArrayList<String> avaliable_subjects = AvaliableSubjectInit.getAvaliable_subjects();
                        //新闻列表
                        ArrayList<String> news = NewsInit.getNews();
                        //学生信息
                        ArrayList<Student> students = StudentInit.getStudents();
                        //老师信息
                        ArrayList<Teacher> teachers = TeacherInit.getTeacherList();
                        try {
                            File file = new File("src/initdata.txt");
                            FileOutputStream fis = new FileOutputStream(file);
                            ObjectOutputStream oos = new ObjectOutputStream(fis);
                            oos.writeObject(avaliable_subjects);
                            oos.writeObject(news);
                            oos.writeObject(students);
                            oos.writeObject(teachers);
                        }catch (Exception e){
                            System.out.println("保存信息失败!");
                        }
                        System.exit(0);
                        break;
                    default:
                        System.out.println("没有该选项！");
                        LoginOrRegisterOrQuit();
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("输入错误，请重新输入!");
        }
    }
    //模拟登陆页面的功能
    public void optIdentity() throws IllegalAccessException, InstantiationException {
        System.out.println("请选择您的身份：");
        System.out.println("1.老师\t2.学生\t3.管理员");
        try {
            int opt = Integer.parseInt(sc.next());
            switch (opt) {
                case 1:
                    teacherLogin();
                    break;
                case 2:
                    studentLogin();
                    break;
                case 3:
                    adminLogin();
                    break;
                default:
                    System.out.println("没有该选项，请重新选择！");
                    optIdentity();
                    break;
            }
        }catch (Exception e){
            System.out.println("输入有误，请重新输入!");
        }
    }


    //模拟注册页面的功能
    public void optRegister() throws InstantiationException, IllegalAccessException {
        try {
            int opt = Integer.parseInt(sc.next());
            switch (opt) {
                case 1:
                    try {
                        System.out.print("姓名：");
                        String name1 = sc.next();
                        System.out.print("性别(男|女)：");
                        char sex1 = sc.next().charAt(0);
                        System.out.print("年龄：");
//                int age1 = sc.nextInt();
                        int age1 = Integer.parseInt(sc.next());
                        System.out.print("用户名：");
                        String s_username = sc.next();

                        boolean exist1 = s_Controller.checkReUserName(s_username);
                        if (exist1) {
                            System.out.println("用户名已经存在，不能有相同的用户名，请重新注册");
                            LoginOrRegisterOrQuit();
                        } else {
                            System.out.print("密码：");
                            String password = sc.next();
                            boolean isRegister = s_Controller.register(name1, sex1, age1, s_username, password);
                            if (isRegister) {
                                System.out.println("恭喜注册成功！");
                            } else {
                                System.out.println("注册失败，请重新注册！");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("输入错误!");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("姓名：");
                        String name = sc.next();
                        System.out.print("性别(男|女):");
                        char sex = sc.next().charAt(0);
                        System.out.print("所教科目：");
                        String Subject = sc.next();
                        System.out.print("年龄：");
//                int age = sc.nextInt();
                        int age = Integer.parseInt(sc.next());
                        System.out.print("用户名：");
                        String username = sc.next();

                        boolean exist = t_Controller.checkReUserName(username);
                        if (exist) {
                            System.out.println("用户名已经存在，不能有相同的用户名，请重新注册");
                            LoginOrRegisterOrQuit();
                        } else {
                            System.out.print("密码：");
                            String password = sc.next();
                            boolean isRegister = t_Controller.register(name, age, sex, Subject, username, password);
                            if (isRegister) {
                                System.out.println("恭喜注册成功！");
                            } else {
                                System.out.println("注册失败，请重新注册！");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("输入有误，请重新输入!");
                    }
                    break;
                default:
                    System.out.println("没有该选项，请重新输入!");
                    break;
            }
        }catch (Exception e){
            System.out.println("输入有误，请重新输入!");
        }
    }

    //*************************管理员功能模块************************
    //用于记录管理管理员使用不同功能的次数
    int adminSelectOne = 0;
    int adminSelectAll = 0;
    //打开选课权限的次数
    int openPer = 0;
    //关闭选课权限的次数
    int closePer = 0;
    //记录发布消息功能使用的次数
    int newsCount = 0;
    static boolean coursePermission = false;
    private void manageTeachers() throws InstantiationException, IllegalAccessException {
        System.out.println("请选择您要进行的操作：");
        System.out.println("*******************");
        System.out.println("1.查询单个老师信息");
        System.out.println("2.查询所有老师信息");
        System.out.println("3.开放选课功能权限");
        System.out.println("4.关闭选课功能权限");
        System.out.println("5.发布消息");
        System.out.println("6.退出");
        System.out.println("*******************");
        try {
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("请输入需要查询的老师的名字");
                    String name = sc.next();
                    Teacher teacher = adminController.selectOneTeacher(name);
                    if (teacher != null) {
                        System.out.println("您要查找的老师信息为：");
                        System.out.println(teacher);
                    } else {
                        System.out.println("你查找的这个老师的信息不存在！");
                    }
                    adminSelectOne += 1;
                    manageTeachers();
                    break;
                case 2:
                    System.out.println("所有的老师信息如下：");
                    ArrayList<Teacher> teachers = adminController.selectAllTeacher();
                    teachers.forEach(System.out::println);
                    adminSelectAll += 1;
                    manageTeachers();
                    break;
                case 3:
                    //公布可选学科
                    try {
                        if(coursePermission==false) {
                            System.out.println("请输入您要公布可选的课程：（以，分隔开）");
                            String subjects = sc.next();
                            if (subjects.endsWith(",")) {
                                subjects = subjects.substring(0, subjects.length() - 1);
                            }
                            String[] sub = subjects.trim().split(",");
                            if (adminController.addAvailableSubjects(sub)) {
                                coursePermission = true;
                                openPer += 1;
                                System.out.println("**************恭喜您添加可选课程成功!**************");
                            } else {
                                System.out.println("**************添加可选课失败，请重新输入!************");
                            }
                        }else{
                            System.out.println("已经开放选课权限!");
                        }
                    } catch (Exception e) {
                        System.out.println("输入格式错误，请重新输入!");
                    }
                    manageTeachers();
                    break;
                case 4:
                    //关闭选课权限，清理可选学科
                    coursePermission = false;
                    if (adminController.clearAvailableSubjects()) {
                        System.out.println("***************选课权限成功关闭*******************");
                        closePer += 1;
                    } else {
                        System.out.println("***************关闭选课权限失败***************");
                    }
                    manageTeachers();
                    break;
                case 5:
                    System.out.println("需要发布的消息内容为：");
                    String news = sc.next();
                    if (adminController.publishNews(news)) {
                        System.out.println("*****************消息发布成功!****************");
                        newsCount += 1;
                    } else {
                        System.out.println("消息发布失败！");
                    }
                    manageTeachers();
                    break;
                case 6:
                    System.out.println("查询单个老师信息功能使用了 " + adminSelectOne + " 次");
                    System.out.println("查询所有老师信息功能使用了 " + adminSelectAll + " 次");
                    System.out.println("开放选课功能权限使用了 " + openPer + " 次");
                    System.out.println("关闭选课功能权限使用了 " + closePer + " 次");
                    System.out.println("消息发布功能使用了 "+newsCount+" 次");
                    System.out.println("*******************欢迎下次使用*******************");
                    adminSelectOne = 0;
                    adminSelectAll = 0;
                    openPer = 0;
                    closePer = 0;
                    newsCount = 0;
                    //退出时需统计功能使用次数的情况
                    LoginOrRegisterOrQuit();
                    break;
                default:
                    System.out.println("没有该选项，请重新选择！");
                    manageTeachers();
                    break;
            }
        }catch (Exception e){
            System.out.println("输入有误，请重新输入!");
            manageTeachers();
        }
    }


    //***********************学生功能模块***************************
    //记录使用次数
    int selectPInfo = 0;
    int updatePInfo = 0;
    int opt_course = 0;
    int scan_courses = 0;
    //记录查看学习成绩使用的次数
    int score_count = 0;
    private void studentOwnManager(String userName,String passWord){
        System.out.println("请选择您要进行的操作：");
        System.out.println("*******************");
        System.out.println("1.查询个人信息");
        System.out.println("2.修改个人信息");
        System.out.println("3.选课");
        System.out.println("4.查看课程表");
        System.out.println("5.查看学习成绩");
        System.out.println("6.退出");
        System.out.println("*******************");
        int opt = 0;
        try {
            opt = Integer.parseInt(sc.next());
            switch (opt){
                case 1:
                    selectPInfo +=1;
                    Student student = showPersonInfo(userName,passWord);
                    if(student!=null){
                        System.out.println("我的个人信息为：");
                        System.out.println(student);
                    }else{
                        System.out.println("查不到个人信息");
                    }
                    studentOwnManager(userName,passWord);
                    break;
                case 2:
                    updatePInfo +=1;
                    showPersonInfo(userName,passWord);
                    System.out.print("姓名:");
                    String name = sc.next();
                    System.out.print("性别(男|女):");
                    char sex = sc.next().charAt(0);
                    System.out.print("年龄:");
                    try {
                        int age = Integer.parseInt(sc.next());
                        Student student1 = showPersonInfo(userName,passWord);
                        if(student1!=null) {
                            boolean isUpdate = s_Controller.updateOwnInfo(student1,name,sex,age);
                            if(isUpdate){
                                System.out.println("*********恭喜您修改个人信息成功!**********");
                                studentOwnManager(userName,passWord);
                            }
                        }
                    }catch (Exception e){
                        System.out.println("输入不正确，请重新操作!");
                        studentOwnManager(userName,passWord);
                    }
                    break;
                case 3:
                    opt_course+=1;
                    if(coursePermission==false){
                        System.out.println("没有开启选课权限，不能进行选课!");
                    }else {
                        Student student1 = showPersonInfo(userName,passWord);
                        //进行选课操作
                        //可选课程有
                        System.out.println("可选课程有：");
                        ArrayList<String> avaliable_subjects = AvaliableSubjectInit.getAvaliable_subjects();
                        int i = 0;
                        Map<Integer,String>num_subject = new HashMap<>();
                        for(String subject:avaliable_subjects){
                            System.out.println(++i+"."+subject);
                            num_subject.put(i,subject);
                        }
                        System.out.println("你要选择的课程是:");
                        String coursenum = sc.next();
                        int coursen = Integer.parseInt(coursenum);
                        String course = num_subject.get(coursen);
                        if(s_Controller.optCourse(userName,passWord,course)){
                            System.out.println("选课成功!");
                        }else{
                            System.out.println("选课失败!");
                        }
                    }
                    studentOwnManager(userName,passWord);
                    break;
                case 4:
                    System.out.println("我的所选课程有：");
                    ArrayList<String> subjects = s_Controller.showSubjects(userName,passWord);
                    subjects.forEach(System.out::println);
                    scan_courses += 1;
                    studentOwnManager(userName,passWord);
                    break;
                case 5:
                    Map<String, Double> subject_score = s_Controller.scanSubjectScore(userName, passWord);
                    Set<Map.Entry<String, Double>> entries = subject_score.entrySet();
                    System.out.println("科目\t\t\t" + "成绩");
                    for(Map.Entry<String,Double>entry:entries){
                        System.out.println(entry.getKey()+"\t\t"+entry.getValue());
                    }
                    score_count +=1;
                    studentOwnManager(userName,passWord);
                    break;
                case 6:
                    System.out.println("查询个人信息功能使用了 "+selectPInfo+" 次");
                    System.out.println("修改个人信息功能使用了 "+updatePInfo+" 次");
                    System.out.println("选课功能权限使用了 "+opt_course+" 次");
                    System.out.println("查看课程表功能使用了 "+scan_courses+" 次");
                    System.out.println("查看学习成绩功能使用了 "+score_count+" 次");
                    System.out.println("*******************欢迎下次使用*******************");
                    selectPInfo = 0;
                    updatePInfo = 0;
                    opt_course = 0;
                    scan_courses = 0;
                    score_count = 0;
                    LoginOrRegisterOrQuit();
                    break;
                default:
                    System.out.println("没有该选项！");
                    studentOwnManager(userName,passWord);
            }
        }catch (Exception e){
            System.out.println("输入选项错误，请重新输入");
            studentOwnManager(userName,passWord);
        }
    }


    //记录使用功能次数
    int scanPersonalInfo = 0;
    int scanAllStudentInfo = 0;
    int addStudentInfo = 0;
    int updateStuInfo = 0;
    int deleteStuInfo = 0;
    int scanRank = 0;
    //*****************************老师功能模块**********************************
    private void teacherOwnManager(String userName,String passWord) {
        System.out.println("请选择您要进行的操作：");
        System.out.println("*******************");
        System.out.println("1.查询所有学生信息");
        System.out.println("2.查询单个学生信息");
        System.out.println("3.添加学员信息");
        System.out.println("4.修改学员信息");
        System.out.println("5.删除学员信息");
        System.out.println("6.查询学生均分排名情况");
        System.out.println("7.退出");
        System.out.println("*******************");
        int opt = Integer.parseInt(sc.next());
        try {
            switch (opt){
                case 1:
                    System.out.println("我的所有的学生信息如下：");
                    ArrayList<Student> students = t_Controller.showAllStudentInfo(userName, passWord);
                    if(students!=null&&students.size()!=0){
                        students.forEach(System.out::println);
                    }else{
                        System.out.println("您当前还没有学生！");
                    }
                    scanAllStudentInfo += 1;
                    teacherOwnManager(userName,passWord);

                    break;
                case 2:
                    System.out.println("请输入你要查询的学员的名字");
                    String name = sc.next();
                    Student student = t_Controller.findStudentByName(name, userName, passWord);
                    if(student!=null){
                        System.out.println("查找到的学员信息为：");
                        System.out.println(student);
                    }else {
                        System.out.println("没有该学员信息!");
                    }
                    scanPersonalInfo += 1;
                    teacherOwnManager(userName,passWord);
                    break;
                case 3:
                    System.out.println("请您输入需要添加的学员名字");
                    String name1 = sc.next();
                    boolean isInsert = t_Controller.insertStudent(name1,userName,passWord);
                    if(isInsert){
                        System.out.println("***********恭喜您添加学生成功*********");
                    }else{
                        System.out.println("已存在该学生信息或无该学生信息，添加失败!");
                    }
                    addStudentInfo+=1;
                    teacherOwnManager(userName,passWord);
                    break;
                case 4:
                    System.out.println("请您输入需要修改的学员名字");
                    String name2 = sc.next();
                    if(t_Controller.updateStudent(name2,userName,passWord)){
                        System.out.println("请输入您要修改的姓名:");
                        String name3 = sc.next();
                        System.out.println("请输入您要修改的性别:");
                        char sex = sc.next().charAt(0);
                        System.out.println("请输入您要修改的年龄:");
                        int age = Integer.parseInt(sc.next());
                        boolean isUpdate = t_Controller.updateStudent1(userName, passWord, name2, name3, sex, age);
                        if(isUpdate){
                            System.out.println("***************恭喜您修改学生信息成功!****************");
                            updatePInfo += 1;
                        }else{
                            System.out.println("修改学生信息失败！");
                        }
                    }else{
                        System.out.println("没有该学员信息，请重新输入!");
                    }
                    teacherOwnManager(userName,passWord);
                    break;
                case 5:
                    System.out.println("请您输入需要删除的学员名字");
                    String name4 = sc.next();
                    boolean isDelete = t_Controller.deleteStudent(name4,userName,passWord);
                    if(isDelete){
                        System.out.println("***********恭喜您删除学生成功*********");
                        deleteStuInfo +=1;
                    }else{
                        System.out.println("没有该学生信息，删除失败!");
                    }
                    teacherOwnManager(userName,passWord);
                    break;
                case 6:
                    ArrayList<Student> students1 = t_Controller.scanStudentsOrder(userName, passWord);
                    if(students1!=null&&students1.size()!=0){
                        System.out.println("学生排名情况如下：");
                        //打印学生名字、各科成绩、以及对应的平均分
//                        System.out.println("姓名\t\t学科\t\t成绩\t\t平均分");
                        for(Student s:students1){
                            String name5 = s.getName();
                            System.out.println("姓名："+name5);
                            s.showSubjectsAndScore();
                            double avg = s.getAvgScore();
                            System.out.println("平均分："+avg);
                            System.out.println("------------------------");
                        }
                    }
                    scanRank += 1;
                    teacherOwnManager(userName,passWord);
                    break;
                case 7:
                    System.out.println("查询所有学生信息功能使用了 "+scanAllStudentInfo+" 次");
                    System.out.println("查看学生个人信息功能使用了 "+scanPersonalInfo+" 次");
                    System.out.println("添加学员信息功能使用了 "+addStudentInfo+" 次");
                    System.out.println("删除学员信息功能使用了 "+deleteStuInfo+" 次");
                    System.out.println("修改学员信息功能使用了 "+updatePInfo+" 次");
                    System.out.println("查询学生均分排名功能使用了 "+scanRank+" 次");
                    System.out.println("*******************欢迎下次使用*******************");
                    scanAllStudentInfo = 0;
                    scanPersonalInfo = 0;
                    addStudentInfo = 0;
                    deleteStuInfo = 0;
                    updatePInfo = 0;
                    scanRank = 0;
                    LoginOrRegisterOrQuit();
                    break;
                default:
                    System.out.println("没有该选项！");
                    teacherOwnManager(userName,passWord);
                    break;
            }
        }catch (Exception e){
            System.out.println("输入选项错误，请重新输入");
            teacherOwnManager(userName,passWord);
        }
    }

    //*****************************小功能模块：用于展示学生个人信息******************
    private Student showPersonInfo(String userName,String passWord){
        Student student = s_Controller.studentSelectOne(userName,passWord);
        if(student!=null){
            return student;
        }else{
            return null;
        }
    }
}
