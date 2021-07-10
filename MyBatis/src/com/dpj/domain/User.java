package com.dpj.domain;

public class User {

    private String uname;
    private String upassword;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uanme='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                '}';
    }

    public User(String uname, String upassword) {
        this.uname = uname;
        this.upassword = upassword;
    }

    public String getUname() {

        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
}
