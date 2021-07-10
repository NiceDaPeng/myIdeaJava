package com.dpj.domain;

public class Books {
    private String bid;
    private String bname;
    private Float bprice;
    private Integer bcount;

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", bcount=" + bcount +
                '}';
    }

    public Books() {
    }

    public Books(String bid, String bname, Float bprice, Integer bcount) {
        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.bcount = bcount;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
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
}
