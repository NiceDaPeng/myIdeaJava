package dpj.bean;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 2257235899404669795L;
    private String id;
    private String name;
    private double money;
    private String password;
    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

    public Customer(){}

    public Customer(String id,String name,double money,String password){
        this.id = id;
        this.name = name;
        this.money = money;
        this.password = password;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getMoney(){
        return this.money;
    }

    public String getPassword(){
        return this.password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof Customer){
            Customer customer = (Customer)obj;
            if (this.id .equals(customer.id)){
                return true;
            }
        }
        return false;
    }

    public int hashCode(){
        return this.id.hashCode();
    }

    public String toString(){
        return this.getId()+"-"+this.getName();
    }
}
