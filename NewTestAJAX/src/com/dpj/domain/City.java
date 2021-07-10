package com.dpj.domain;

public class City {

    private Integer cityid;
    private String cityname;
    private Integer citysize;
    private Integer aid;

    public City() {
    }

    public City(Integer cityid, String cityname, Integer citysize, Integer aid) {

        this.cityid = cityid;
        this.cityname = cityname;
        this.citysize = citysize;
        this.aid = aid;
    }

    public Integer getCityid() {

        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getCitysize() {
        return citysize;
    }

    public void setCitysize(Integer citysize) {
        this.citysize = citysize;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}
