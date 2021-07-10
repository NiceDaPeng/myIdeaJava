package com.dpj.domain;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 7193346149169179709L;
    private String name;
    private Integer age;
    private String sex;
    private Wallet wallet;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", wallet=" + wallet +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public User(String name, Integer age, String sex, Wallet wallet) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.wallet = wallet;
    }

    public User() {
    }

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
