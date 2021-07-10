package domain;

import java.util.Objects;

public class Customer {

    private String userid;
    private String userName;
    private String password;
    private Float balance;

    public Customer() {
    }

    public Customer(String userid, String userName, String password, Float balance) {

        this.userid = userid;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
    }

    public Customer(String userid, String userName, Float balance) {
        this.userid = userid;
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserid() {

        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userid='" + userid + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(userid, customer.userid) &&
                Objects.equals(userName, customer.userName) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(balance, customer.balance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userid);
    }
}
