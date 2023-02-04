package exampleAccount;

/**
 * @program: 账户类
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-02-04 14:54
 * @LastEditTime: 2023-02-04 14:54
 */

public class Account {
    /**
     * 私有
     */
    private String cardId;//卡号
    private String userName;
    private String password;
    private double balance;//帐户余额
    private double quoteMoney;//取现余额
    private String Sex;


//    public Account(){
//    }
//    public Account(String cardId, String userName, String password, double balance, double quoteMoney) {
//        this.cardId = cardId;
//        this.userName = userName;
//        this.password = password;
//        this.balance = balance;
//        this.quoteMoney = quoteMoney;
//    }
    public String getSex() {
       return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getQuoteMoney() {
        return quoteMoney;
    }

    public void setQuoteMoney(double quoteMoney) {
        this.quoteMoney = quoteMoney;
    }
}
