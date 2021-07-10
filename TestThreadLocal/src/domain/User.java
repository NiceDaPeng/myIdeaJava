package domain;

public class User {

    private String aname;
    private String apassword;
    private Float abalance;

    public User() {
    }

    public User(String aname, String apassword, Float abalance) {

        this.aname = aname;
        this.apassword = apassword;
        this.abalance = abalance;
    }

    public Float getAbalance() {
        return abalance;
    }

    public void setAbalance(Float abalance) {
        this.abalance = abalance;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }
}
