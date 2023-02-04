package exampleAccount;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;




/**
 * @program:
 * @description:ATM系统入口类
 * @Creator: 阿昇
 * @CreateTime: 2023-02-04 14:58
 * @LastEditTime: 2023-02-04 14:58
 */
//启动类
public class ATNSystem {
    public static void main(String[] args) {
        //1.定义账户类
        //2.定义集合容器,负责以后存储全部的账户对象,进行相关业务操作
        ArrayList<Account> accounts = new ArrayList<>();
        //3.展示系统首页
        Scanner sc = new Scanner(System.in);
        //快捷键:选择要while循环部份ctrl+alt+t
        while (true) {
            System.out.println("==========================帅哥ATM系统==========================");
            System.out.println("1、账户登入");
            System.out.println("2、账户开户");

            System.out.println("请选择操作:");
            int command = sc.nextInt();

            switch (command){
                case 1:
                    //登入
                    login(accounts,sc);
                    break;
                case 2:
                    //开户
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("您输入的操作不存在");
            }
        }

    }

    /**
     * 登入功能
     * @param accounts  全部账户对象的集合
     * @param sc 扫描器
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("=============系统登入操作============");
        //1.判断集合中判断是否存在账户,如果不存在账户,登录功能不可进行
        if(accounts == null){
            System.out.println("对不起,当前系统中,无任何账户,请先开户再作登陆");
            return;//卫语言风格,解决方法的执行
        }
    }

    /**
     * //用户开户功能
     * @param accounts 接收的账户集合
     * @param sc
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("================系统开户操作============");
        //1.创借一个账户对象,用于之后封装信息
        Account account = new Account();

        //2.写入当前这个账户的信息,注入到帐户对象中去
        System.out.println("请您输入帐户用户名:");
        String userName = sc.next();
        account.setUserName(userName);
        System.out.println("请您输入性别:Male/Female");
        String Sex = sc.next();
        if(Sex.equals(Sex.contains("Male")) || Sex.equals(Sex.contains("Female")) || Sex.equals(Sex.contains("男")) || Sex.equals(Sex.contains("女"))){
            if(Sex.equals("Male")){
                account.setSex("先生");
            }else if(Sex.equals("Female")){
                account.setSex("女士");
            }
        }else{
            System.out.println("请输入正确性别");
        }
        while (true) {
            System.out.println("请您输入密码:");
            String password = sc.next();
            System.out.println("请确认密码:");
            String passwordok = sc.next();
            if(password.equals(passwordok)){
                account.setPassword(passwordok);
                System.out.println("密码确认成功");
                break;
            }else{
                System.out.println("密码不一致,请再次确认.....");
            }
        }

        System.out.println("请您输入帐户当次限额:");
        double quoteMoney = sc.nextDouble();
        account.setQuoteMoney(quoteMoney);

        //为账户生成8位不重复的号码(独立功能,独立方法)
        String cardId = getRamdomCardId(accounts);
        account.setCardId(cardId);

        //3.把账户对象添加到帐户集合中去****************************************
        accounts.add(account);
        System.out.println("恭喜您:"+userName+Sex+"您开户成功,  您的卡号是:" + cardId + "请您妥善保管");
    }

    /**
     *为账户生成8位与其他账户卡号不同的号码
     *
     * @return 卡号
     */
    private static String getRamdomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            //1.先生成8位数字
            String cardId = "";
            for (int i = 0; i <8 ; i++) {
                cardId += r.nextInt(10);
            }

            //2.判断这8位卡号是否与其他卡号重复
            //根据这卡号查询此账户的对象
            Account acc = getAccountByCardId(cardId,accounts);
            if(acc == null){
                System.out.println("卡号目前无重复,可使用");
                return cardId;
            }
        }
    }

    /**
     * 根据卡号查询出一个账户对象出来
     * @param cardId 卡号
     * @param accounts 全部账户的集合
     * @return
     */
    private static Account getAccountByCardId (String cardId,ArrayList<Account>accounts){
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if(acc.getCardId().equals(cardId)){
                return acc;
            }
        }
        return null;
    }
}
