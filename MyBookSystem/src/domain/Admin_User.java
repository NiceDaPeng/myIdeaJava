package domain;

public class Admin_User {

    private String aname;
    private String apassword;

    public Admin_User() {
    }

    public Admin_User(String aname, String apassword) {

        this.aname = aname;
        this.apassword = apassword;
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

    @Override
    public String toString() {
        return "Admin_User{" +
                "aname='" + aname + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }
}
