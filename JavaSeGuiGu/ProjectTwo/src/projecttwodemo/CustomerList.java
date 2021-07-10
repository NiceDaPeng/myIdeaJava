package projecttwodemo;

public class CustomerList {

    private static int size = 10;
    public static Customer[] customers = new Customer[size];

    private int total = 0;

    public CustomerList(){}

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
        size = totalCustomer;
    }

    public  boolean addCustomer(Customer customer){

        customers = CustomerUtil.ensuerCapacity(customers,size);

        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index,Customer cust){


        return false;
    }

    public boolean deleteCustomer(int index){

        return false;
    }

    public Customer[] getAllCustomers(){
        for (Customer customer : customers){
            if (customer != null)
            System.out.println(customer);
        }
        return customers;
    }

    public Customer getCustomer(int index){

        return new Customer();
    }
}
