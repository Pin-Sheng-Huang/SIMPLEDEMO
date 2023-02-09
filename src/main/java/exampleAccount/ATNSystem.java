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
                case 3:
                    System.exit(0);
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
        if(accounts.size() == 0){
            System.out.println("对不起,当前系统中,无任何账户,请先开户再作登陆");
            return;//卫语言风格,解决方法的执行
        }

        //2.正式进入登入操作
        while (true) {
            System.out.println("请您输入登录卡号");
            String cardId = sc.next();
            //3.看卡号在不在,根据卡号集合去查询账户对象
            Account acc = getAccountByCardId(cardId,accounts);
            if(acc != null){
                while (true) {
                    //卡号存在
                    //4.让用户输入密码,认证密码
                    System.out.println("请您输入登录密码");
                    String password = sc.next();
                    //判断当前用户密码是否正确 ,比对内容物是否相等使用equals
                    if(acc.getPassword().equals(password)){
                        System.out.println(acc.getUserName()+acc.getSex()+"登入成功,您的卡号是:"+acc.getCardId());
                        //..查询..取款..转账
                        //展示登陆后的操作页
                        showUserCommand(sc,acc,accounts);
                        return; //干掉登入方法
                    }else{
                        System.out.println("密码有误");
                    }
                }
            }else{
                System.out.println("不存在该账户卡号");
            }
        }
    }
    public static int count = 1;
    public static int countTransfer = 1;
    public static int deleteAccount = 1;
    /**
     * 展示登入后的操作页
     */
    private static void showUserCommand(Scanner sc, Account acc, ArrayList<Account> accounts) {
        while (true) {
            System.out.println("===========用户操作页==========");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销帐户");
            System.out.println("请选择:");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //查询账户(展示登入的账户)
                    showAccount(acc);
                    break;
                case 2:
                    //存款
                    saveMoney(acc,sc);
                    break;
                case 3:
                    //取款
                    withdrawMoney(acc,sc);
                    //使用count 来计算这方法调用了几次,来增加手续费
                    count++;
                    break;
                case 4:
                    //转账
                    transferMoney(acc,accounts,sc);
                    countTransfer++;
                    break;
                case 5:
                    //修改密码
                    updatePassWord(sc,acc);
                    return;//干掉当前方法的执行,需要往上返回
                case 6:
                    //退出
                    System.out.println("退出账户,谢谢光临");
                    return;//干掉当前方法的执行
                case 7:
                    //注销帐户
                    if(deleteAccount(acc,sc,accounts)){
                        return;//true的话回首页
                    }else {
                        //还是回到操作页面
                        deleteAccount++;
                        break;
                    }

                default :
                    System.out.println("您输入的操作不正确");

            }
        }
    }

    /**
     * boolean 返回值
     * 销户功能
     * @param acc
     * @param sc
     * @param accounts
     */
    private static boolean deleteAccount(Account acc, Scanner sc, ArrayList<Account> accounts) {
        System.out.println("==========用户销户功能=============");
        System.out.println("您真的删除帐户?y/n");
        String rs = sc.next();
        switch (rs){
            case "y":
                if(acc.getBalance()>0 && deleteAccount<2){ //deleteAccount<2 里头有余额给他一次机会,再有余额直接注销
                    System.out.println("您账户还有金额不可销户");
                }else {
                    accounts.remove(acc);
                    System.out.println("您的账户销户完成");
                    return true;
                }
                break;
            default:
                System.out.println("好的,当前继续保留");
        }
        return false;
    }

    /**
     * 修改密码
     * @param sc 扫描器
     * @param acc 当前登陆成功的账户对象
     */
    private static void updatePassWord(Scanner sc, Account acc) {
        while (true) {
            System.out.println("===============用户密码修改=============");
            System.out.println("请输入当前密码:");
            String password = sc.next();
            //判断密码是否正确
            if(password.equals(acc.getPassword())){
                while (true) {
                    //密码正确
                    //输入新密码
                    System.out.println("请输入新密码");
                    String newpassword = sc.next();
                    System.out.println("请确认新密码");
                    String oknewpassword = sc.next();
                    if(newpassword.equals(oknewpassword)){
                        acc.setPassword(oknewpassword);
                        System.out.println("恭喜修改成功");
                        return;
                    }else{
                        System.out.println("密码不一致,请检查");
                    }
                }
            }else{
                System.out.println("密码不正确");
            }
        }
    }

    /**
     * 转账功能
     * @param acc 自己账户对象
     * @param accounts 全部账户的集合
     * @param sc 扫描器
     */
    private static void transferMoney(Account acc, ArrayList<Account> accounts, Scanner sc) {
        System.out.println("========用户转账操作=========");
        //1.判断是否有两个账户
        if(accounts.size() < 2){
            System.out.println("当前系统中不够两个账户,不能进行转账");
            return;//结束该方法
        }
        //2.判断自己的账户是否有钱
        if(acc.getBalance() == 0){
            System.out.println("账户为0元,就别转了");
            return;//结束该方法
        }
        while (true) {
            //3.开始转帐
            System.out.println("请输入对方的卡号");
            String cardId = sc.next();

            if(countTransfer >3){
                System.out.println("转账额度超过"+(countTransfer-1)+"次,请明日再转");
                return;
            }

            //卡号不得为自己的卡号
            if(cardId.equals(acc.getCardId())){
                System.out.println("不得转给自己");
                continue;//结束当次执行,死循环进入下一次
            }
            //判断卡号在不在,把对方账户对象捞出来
            Account account = getAccountByCardId(cardId,accounts);
            if(account == null){
                System.out.println("Sorry,这个卡号不存在");
            }else{//这个账户存在
                String userName = account.getUserName();
                String tip = "*" +userName.substring(1);
                System.out.println("请您输入["+tip+"]姓氏");
                String preName = sc.next();

                //认证姓氏是否正确
                if(userName.startsWith(preName)){//从userName 开始
                    while (true && countTransfer <= 3) {
                        //认证通过
                        System.out.println("请您输入转账金额");
                        Double money = sc.nextDouble();
                        if(money > acc.getBalance()){
                            System.out.println("您的账户没那么多钱,您的余额只有" + acc.getBalance());
                        }else{
                            if(countTransfer <= 3) {//-->加个小判断
                                //余额足够
                                acc.setBalance(acc.getBalance() - money);
                                account.setBalance(account.getBalance() + money);
                                System.out.println("转账成功!剩余金额" + acc.getBalance());
                                return;
                            }
                        }

                    }
                }  else{
                    System.out.println("输入信息有误");
                }
            }
        }
    }



    /**
     * 取钱
     * @param acc
     * @param sc
     */
    private static void withdrawMoney(Account acc, Scanner sc) {
        System.out.println("===========用户取钱操作==========");
        //判断是否有钱
        if(acc.getBalance() < 1000){
            System.out.println("当前用户余额小于1000元,不可取款");
            return;
        }
        //int count = 1;
        while (true) {
            //2.提示用户取款金额
            System.out.println("输入取款金额");
            Double money = sc.nextDouble();
            if(money < acc.getQuoteMoney()) {
                //3.判断金额是否满足要求
                if (money > acc.getBalance()) {
                    System.out.println("余额不足,目前总余额:" + acc.getBalance());
                } else {
                    if (count <= 3) {
                        System.out.println(count);
                        //恭喜取钱成功
                        System.out.println("取钱" + money + "成功" + "今日取款免手续次数剩下:" + (3 - count) + "次");
                        //更新于额
                        acc.setBalance(acc.getBalance() - money);

                        //增加手续费100元
                    } else if (count > 3 && acc.getBalance()-100 > 0) {
                        acc.setBalance(acc.getBalance() - money - 100);
                        System.out.println("取钱" + money + "成功,额外扣除手续费100元整");
                    }
                    //今日限额(黑心银行)
                    acc.setQuoteMoney(acc.getQuoteMoney()-money);
                    System.out.println("今日限额剩余:"+acc.getQuoteMoney());
                    //取前成功 show信息
                    showAccount(acc);
                    return;

                }
            }else{
                System.out.println("当日限额不足仅剩:"+acc.getQuoteMoney());
                return;
            }
        }

    }


    private static void withdrawMoney() {
    }

    /**
     * 存钱
     * @param acc 当前账户
     * @param sc 扫描器
     */
    private static void saveMoney(Account acc,Scanner sc) {
        System.out.println("=======欢迎您进入帅哥银行========");
        System.out.println("请您输入存款金额");
        double money = sc.nextDouble();
        //更新账户余额 - 原有的钱+上新存的钱
        acc.setBalance(acc.getBalance()+money);
        System.out.println("存钱成功,当前账户信息如下");
        showAccount(acc);
    }

    /**
     * 展示账户信息
     * @param acc
     */
    private static void showAccount(Account acc) {
        System.out.println("============当前账户信息如下==========");
        System.out.println("卡号:"+acc.getCardId());
        System.out.println("姓名:"+acc.getUserName());
        System.out.println("账户余额:"+acc.getBalance());
        System.out.println("当日取钱限额:"+acc.getQuoteMoney());
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
        String Sex = null;
        ArrayList<String> Sex1 = new ArrayList<>();
        Sex1.add("Male");Sex1.add("Female");Sex1.add("男");Sex1.add("女");
        while (true) {
            System.out.println("请您输入性别:Male/Female");
            String Sexsc = sc.next();

            if(Sexsc.equals("Male") || Sexsc.equals("Female") || Sexsc.equals("男") || Sexsc.equals("女")){
                if(Sexsc.equals("Male") || Sexsc.equals("男")){
                    account.setSex("先生");
                }else if(Sexsc.equals("Female") || Sexsc.equals("女")){
                    account.setSex("女士");
                }
                break;
            }else{
                System.out.println("请输入正确性别");
                System.out.println(Sexsc);
            }
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

        System.out.println("请您输入帐户当日取钱限额:");
        double quoteMoney = sc.nextDouble();
        account.setQuoteMoney(quoteMoney);

        //为账户生成8位不重复的号码(独立功能,独立方法)
        String cardId = getRamdomCardId(accounts);
        account.setCardId(cardId);

        //3.把账户对象添加到帐户集合中去****************************************
        accounts.add(account);
        System.out.println("恭喜您:"+userName+account.getSex()+"您开户成功,  您的卡号是:" + cardId+ ","+ " 请您妥善保管");
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
