package domain;

import java.util.Objects;

public class Customers {
    private Integer cid;
    private String cname;
    private Float cbalance;

    public Customers() {
    }

    public Customers(Integer cid, String cname, Float cbalance) {

        this.cid = cid;
        this.cname = cname;
        this.cbalance = cbalance;
    }

    public Integer getCid() {

        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Float getCbalance() {
        return cbalance;
    }

    public void setCbalance(Float cbalance) {
        this.cbalance = cbalance;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cbalance=" + cbalance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Float.compare(customers.cbalance, cbalance) == 0 &&
                Objects.equals(cid, customers.cid) &&
                Objects.equals(cname, customers.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid);
    }
}
