package com.dpj.domain;

public class Area {

    private Integer aid;
    private String aname;
    private Integer cid;

    public Area() {
    }

    public Area(Integer aid, String aname, Integer cid) {

        this.aid = aid;
        this.aname = aname;
        this.cid = cid;
    }

    public Integer getAid() {

        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
