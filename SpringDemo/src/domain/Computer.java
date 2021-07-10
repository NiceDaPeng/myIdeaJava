package domain;

public class Computer {
    private String model;
    private String brand;
    private Float price;

    public Computer() {
    }

//    @Override
//    public String toString() {
//        return "Computer{" +
//                "model='" + model + '\'' +
//                ", brand='" + brand + '\'' +
//                ", price=" + price +
//                '}';
//    }

    public Computer(String model, String brand, Float price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
