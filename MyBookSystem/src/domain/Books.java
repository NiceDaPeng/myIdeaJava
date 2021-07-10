package domain;

public class Books {

    private Integer bid;
    private String bname;
    private Float bprice;
    private String bdescription;
    private Book_Kind bookKind;

    public Books() {
    }

    public Books(Integer bid, String bname, Float bprice, String bdescription, Book_Kind bookKind) {

        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.bdescription = bdescription;
        this.bookKind = bookKind;
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

    public String getBdescription() {
        return bdescription;
    }

    public void setBdescription(String bdescription) {
        this.bdescription = bdescription;
    }

    public Book_Kind getBookKind() {
        return bookKind;
    }

    public void setBookKind(Book_Kind bookKind) {
        this.bookKind = bookKind;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", bdescription='" + bdescription + '\'' +
                ", bookKind=" + bookKind +
                '}';
    }
}
