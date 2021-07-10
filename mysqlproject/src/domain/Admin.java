package domain;

public class Admin {

    private String aname;
    private String apassword;

    public Admin() {
    }

    public Admin(String aname, String apassword) {

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
        return "Admin{" +
                "aname='" + aname + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }
}
