package domain;

public class Book {

    private Integer bid;
    private String bname;
    private Float bprice;
    private Integer bcount;

    public Book() {
    }

    public Book(Integer bid, String bname, Float bprice, Integer bcount) {

        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.bcount = bcount;
    }

    public Integer getBid() {

        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Float getBprice() {
        return bprice;
    }

    public void setBprice(Float bprice) {
        this.bprice = bprice;
    }

    public Integer getBcount() {
        return bcount;
    }

    public void setBcount(Integer bcount) {
        this.bcount = bcount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", bcount=" + bcount +
                '}';
    }
}
