package domain;

public class Book_Kind {

    private Integer bkid;
    private String bkname;

    public Book_Kind() {
    }

    public Book_Kind(Integer bkid, String bkname) {

        this.bkid = bkid;
        this.bkname = bkname;
    }

    public Integer getBkid() {

        return bkid;
    }

    public void setBkid(Integer bkid) {
        this.bkid = bkid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    @Override
    public String toString() {
        return "Book_Kind{" +
                "bkid=" + bkid +
                ", bkname='" + bkname + '\'' +
                '}';
    }
}
