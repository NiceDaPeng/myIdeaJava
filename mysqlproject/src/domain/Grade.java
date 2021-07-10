package domain;

public class Grade {

    private Integer gid;
    private String gname;

    public Grade() {
    }

    public Grade(Integer gid, String gname) {

        this.gid = gid;
        this.gname = gname;
    }

    public Integer getGid() {

        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                '}';
    }
}
