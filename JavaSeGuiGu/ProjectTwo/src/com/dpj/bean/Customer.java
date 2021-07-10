package com.dpj.bean;

public class Customer {

    private String name;
    private String gender;
    private int age;
    private String phone;
    private String email;
    private int no = 0;

    public Customer(String name, String gender, int age, String phone, String email) {

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return this.getName()+"\t\t\t"+this.getGender()+"\t\t\t"+this.getAge()
                +"\t\t\t"+this.getPhone()+"\t\t\t"+this.getEmail();
    }

    public boolean equals(Object obj){
        if (this == obj){
            return false;
        }

        if (obj instanceof Customer){
            Customer cos = (Customer)obj;
            if (this.name.equals(cos.name)){
                return true;
            }
        }
        return false;
    }

    public int hashCode(){
        return this.name.hashCode() +this.phone.hashCode();
    }
}
