package simulationtickets;

public class Ticket {

    private String from;
    private String end;
    private Float price;

    public Ticket(String from,String end,Float price){
        this.from = from;
        this.end =end;
        this.price =price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        builder.append(this.from);
        builder.append(",");
        builder.append(this.end);
        builder.append("价格：");
        builder.append(this.price);
        return builder.toString();
    }
}
