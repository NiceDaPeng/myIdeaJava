package day2205;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {

    private static Integer sale;
    private String name;
    private transient Double price;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Student(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Student() {
    }

    public static Integer getSale() {
        return sale;
    }

    public static void setSale(Integer sale) {
        Student.sale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeDouble(price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        sale = in.readInt();
    }
}
