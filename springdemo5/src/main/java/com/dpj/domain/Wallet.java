package com.dpj.domain;

import java.io.Serializable;

public class Wallet implements Serializable {

    private static final long serialVersionUID = 8114994391807567656L;
    private String color;
    private String money;

    @Override
    public String toString() {
        return "Wallet{" +
                "color='" + color + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public Wallet() {
    }

    public Wallet(String color, String money) {
        this.color = color;
        this.money = money;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
