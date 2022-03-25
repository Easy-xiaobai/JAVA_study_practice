package StudentManageSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class studentManage {
    public static void main(String[] args) {
        ArrayList<student> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int shuru;
        // 主界面一直运行 或者使用do while（shuru！=5）语句实现 在循环外面定义int shuru
        while (true) {
            System.out.println("------欢迎来到学生信息管理系统------");
            System.out.println("1  添加学生信息");
            System.out.println("2  删除学生信息");
            System.out.println("3  修改学生信息");
            System.out.println("4  查看所有学生信息");
            System.out.println("5  退出系统");
            System.out.println("   请输入你的选择：");
            shuru = sc.nextInt();
            switch (shuru) {
                case 1:
                    addstudent(array);//调用添加方法
                    break;
                case 2:
                    deletestudent(array);
                    break;
                case 3:
                    updatestudent(array);
                    break;
                case 4:
                    findstudent(array);
                    break;
                case 5:
                    System.out.println("谢谢使用");
                    System.exit(0);//jvm退出
            }
        }
    }

    //定义一个方法，用于添加学生信息
    public static void addstudent(ArrayList<student> array) {
        //录入学生信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要添加的学生学号");
        String id = sc.nextLine();
        if (check(id, array)) {   //判断要添加的学号是否存在
            System.out.println("请输入你要添加的学生姓名");
            String name = sc.nextLine();
            System.out.println("请输入你要添加的学生年龄");
            String age = sc.nextLine();
            System.out.println("请输入你要添加的学生地址");
            String address = sc.nextLine();
            //创建学生对象 接收这些数据
            student s = new student();
            s.setName(name);
            s.setAge(age);
            s.setId(id);
            s.setAddress(address);
            //将学生对象添加到集合中去
            array.add(s);
            System.out.println("添加成功");
        } else {
            System.out.println("该学号已存在！");
        }
    }

    //定义一个方法，用于查看所有学生信息
    public static void findstudent(ArrayList<student> array) {
        if (array.size() != 0) {
            System.out.println("学号 姓名  年龄  地址");
            for (int i = 0; i < array.size(); i++) {
                student s = array.get(i);
                System.out.print(s.getId() + "  ");
                System.out.print(s.getName() + "  ");
                System.out.print(s.getAge() + "岁  ");
                System.out.println(s.getAddress() + "  ");
            }
        } else {
            System.out.println("无信息，请先添加信息在查询！");
        }

    }

    //定义一个方法，用于删除学生信息
    public static void deletestudent(ArrayList<student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号：");
        String sid = sc.nextLine();
        if (check(sid,array)==false) {
            //遍历集合 将对应的学生对象从集合删除
            student s;
            int flag = 0;
            for (int i = 0; i < array.size(); i++) {
                s = array.get(i);
                if (s.getId().equals(sid)) {  //判断要删除的学号是否和遍历对象的学号相同
                    array.remove(i);
                    flag++;
                    break;
                }
            }
            if (flag == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("该学号不存在！");
        }
    }

    //定义一个方法，用于修改学生信息
    public static void updatestudent(ArrayList<student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生学号");
        String xid = sc.nextLine();
        if (check(xid,array)==false)
        {
            System.out.println("请选择你要修改的项目：");
            System.out.println("1  修改学生姓名");
            System.out.println("2  修改学生年龄");
            System.out.println("3  修改学生地址");
            System.out.println("4  退出修改");
            int xg = sc.nextInt();
            System.out.println("请输入新的信息：");
            String xin = sc.next();
            //遍历集合 找到要修改的学生
            student s;
            int flag = 0;
            for (int i = 0; i < array.size(); i++) {
                s = array.get(i);
                if (s.getId().equals(xid)) {
                    switch (xg) {
                        case 1:
                            s.setName(xin);
                            array.set(i, s);
                            System.out.println("修改姓名完成");
                            flag++;
                            break;
                        case 2:
                            s.setAge(xin);
                            array.set(i, s);
                            System.out.println("修改年龄完成");
                            flag++;
                            break;
                        case 3:
                            s.setAddress(xin);
                            array.set(i, s);
                            System.out.println("修改地址完成");
                            flag++;
                            break;
                        case 4:
                            break;

                    }
                }
            }
            if (flag == 0) {
                System.out.println("修改失败");
            }
        }else{
            System.out.println("该学号不存在！");
        }
    }

    //定义一个方法检测是否学号存在  如果查询id已存在就是重复的 返回false 如果没存在就返回true
    public static boolean check(String cxid, ArrayList<student> array) {
        student s;
        boolean flag=true;
        for (int i = 0; i < array.size(); i++) {
            s = array.get(i);
            if (s.getId().equals(cxid)) {
                flag = false;
            }
        }
        return flag;
    }
}
