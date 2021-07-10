package domain;

public class Commodity {

    private String commid;
    private String commName;
    private Float commPrice;
    private Category category;

    public Commodity() {
    }

    public Commodity(String commid, String commName, Float commPrice, Category category) {

        this.commid = commid;
        this.commName = commName;
        this.commPrice = commPrice;
        this.category = category;
    }

    public String getCommid() {

        return commid;
    }

    public void setCommid(String commid) {
        this.commid = commid;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Float getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(Float commPrice) {
        this.commPrice = commPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commid='" + commid + '\'' +
                ", commName='" + commName + '\'' +
                ", commPrice=" + commPrice +
                ", category=" + category +
                '}';
    }
}
