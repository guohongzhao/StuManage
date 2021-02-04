package ltd.storming.Test;

import ltd.storming.Domain.Student;
import ltd.storming.Domain.Teacher;
import ltd.storming.Utils.Tools;

import java.util.ArrayList;
import java.util.Scanner;

import static ltd.storming.Utils.Tools.printPerson;

public class mainApp {
    public static void main(String[] args) {
        // 一级菜单
        Scanner sc = new Scanner(System.in);
        System.out.println("管理系统启动......");
        ArrayList<Student> stuL = new ArrayList<>();
        ArrayList<Teacher> teaL = new ArrayList<>();
        while (true){
            System.out.println("1.学生信息管理系统    2.教师信息管理系统    3.退出");
            int i = sc.nextInt();
            switch (i) {
                case 1 -> stuManage(stuL, sc);
                case 2 -> teaManage(teaL, sc);
                case 3 -> System.exit(0);
                default -> System.out.println("输入有误...");
            }
        }
    }


    private static void stuManage(ArrayList<Student> stuL,Scanner sc) {
        while(true){
            System.out.println("学生管理系统...");
            System.out.println("1.增   2.删   3.改   4.查   5.返回上一级");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    System.out.println("请输入姓名：");
                    String name = sc.next();
                    System.out.println("请输入性别：");
                    String sex = sc.next();
                    System.out.println("请输入生日：");
                    String bir = sc.next();
                    try{
                        stuL.add(new Student(Student.sid,name,sex,bir,Tools.BirthdayToAge(bir)));
                        Student.sid = Student.sid +1;
                    }catch (Exception e){
                        System.out.println("输入错误...");
                    }
                    break;
                case 2:
                    System.out.println("请输入ID：");
                    int id = sc.nextInt();
                    int flag =0;
                    for (int i1 = 0; i1 < stuL.size(); i1++) {
                        if (id==stuL.get(i1).getId()){
                            flag =1;
                            printPerson(stuL.get(i1));
                            System.out.println("是否删除：y/n");
                            String d = sc.next();
                            if (d.equalsIgnoreCase("y")){
                                stuL.remove(i1);
                                System.out.println("删除成功...");
                            }else{
                                System.out.println("取消删除...");
                            }
                            break;
                        }
                    }
                    if (flag==0){
                        System.out.println("无此用户...");
                    }
                    break;
                case 3:
                    // 改
                    System.out.println("请输入ID：");
                    id = sc.nextInt();
                    flag =0;
                    for (Student student : stuL) {
                        if (id == student.getId()) {
                            flag = 1;
                            printPerson(student);
                            System.out.println("保留原值请填写0");
                            System.out.println("请输入姓名：");
                            name = sc.next();
                            System.out.println("请输入性别：");
                            sex = sc.next();
                            System.out.println("请输入生日：");
                            bir = sc.next();
                            try {
                                if (!"0".equals(name)){
                                    student.setName(name);
                                }
                                if (!"0".equals(sex)){
                                    student.setSex(sex);
                                }
                                if (!"0".equals(bir)){
                                    student.setBirthday(bir);
                                    student.setAge(Tools.BirthdayToAge(bir));
                                }
                            } catch (Exception e) {
                                System.out.println("输入错误...");
                            }
                            break;
                        }
                    }
                    if (flag==0){
                        System.out.println("无此用户...");
                    }
                    break;
                case 4:
                    if (stuL.size()>0){
                        for (Student student : stuL) {
                            printPerson(student);
                        }
                    }else {
                        System.out.println("无数据...");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入有误...");
                    break;
            }
        }
    }

    private static void teaManage(ArrayList<Teacher> teaL,Scanner sc) {
        while(true){
            System.out.println("教师管理系统...");
            System.out.println("1.增   2.删   3.改   4.查   5.返回上一级");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    System.out.println("请输入姓名：");
                    String name = sc.next();
                    System.out.println("请输入性别：");
                    String sex = sc.next();
                    System.out.println("请输入生日：");
                    String bir = sc.next();
                    try{
                        teaL.add(new Teacher(Teacher.tid,name,sex,bir,Tools.BirthdayToAge(bir)));
                        Teacher.tid = Teacher.tid +1;
                    }catch (Exception e){
                        System.out.println("输入错误...");
                    }
                    break;
                case 2:
                    System.out.println("请输入ID：");
                    int id = sc.nextInt();
                    int flag =0;
                    for (int i1 = 0; i1 < teaL.size(); i1++) {
                        if (id==teaL.get(i1).getId()){
                            flag =1;
                            printPerson(teaL.get(i1));
                            System.out.println("是否删除：y/n");
                            String d = sc.next();
                            if (d.equalsIgnoreCase("y")){
                                teaL.remove(i1);
                                System.out.println("删除成功...");
                            }else{
                                System.out.println("取消删除...");
                            }
                            break;
                        }
                    }
                    if (flag==0){
                        System.out.println("无此用户...");
                    }
                    break;
                case 3:
                    // 改
                    System.out.println("请输入ID：");
                    id = sc.nextInt();
                    flag =0;
                    for (Teacher teacher : teaL) {
                        if (id == teacher.getId()) {
                            flag = 1;
                            printPerson(teacher);
                            System.out.println("请输入姓名：");
                            name = sc.next();
                            System.out.println("请输入性别：");
                            sex = sc.next();
                            System.out.println("请输入生日：");
                            bir = sc.next();
                            try {
                                if (!"0".equals(name)){
                                    teacher.setName(name);
                                }
                                if (!"0".equals(sex)){
                                    teacher.setSex(sex);
                                }
                                if (!"0".equals(bir)){
                                    teacher.setBirthday(bir);
                                    teacher.setAge(Tools.BirthdayToAge(bir));
                                }
                            } catch (Exception e) {
                                System.out.println("输入错误...");
                            }
                            break;
                        }
                    }
                    if (flag==0){
                        System.out.println("无此用户...");
                    }
                    break;
                case 4:
                    if (teaL.size()>0){
                        for (Teacher teacher : teaL) {
                            printPerson(teacher);
                        }
                    }else {
                        System.out.println("无数据...");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入有误...");
                    break;
            }
        }
    }
}
