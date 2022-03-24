package Landing;

import java.util.Scanner;

/*
已知用户名和密码，用程序模拟用户登录，给三次机会，登陆之后，给出相应的提示。
 */
public class LandingText {
    public static void main(String[] args) {
        //定义两个字符串 用户名和密码
        String UserName = "李果果";
        String PassWord = "lxy666";
        for (int i = 0; i < 3; i++) {
            //键盘录入登录的用户名和密码，用Scanner实现
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name = sc.nextLine();
            System.out.println("请输入登录密码：");
            String word = sc.nextLine();

            //进行比较
            if (name.equals(UserName) & word.equals(PassWord)) {
                System.out.println("登陆成功");
                break; //登陆成功 跳出循环
            } else if (2 - i == 0) {
                System.out.println("您已输入错误三次，您的账户已被锁定，请与管理员联系");
            } else {
                System.out.println("用户名或密码错误！登陆失败！您还有" + (2 - i) + "次机会");
            }
        }
    }
}
