package projecttwodemo;

public class CustomerUtil {

    //设计一个方法用来判断数组空间是否够用

    public static Customer[] ensuerCapacity(Customer[] customers,int minCapacity){

        if (minCapacity <= 0){
            throw new CustomerException("空间容量 < 0");
        }
        int oldCapacity = customers.length;
        if (minCapacity - oldCapacity <= 0){
            customers = grow(customers,minCapacity);
        }
        return customers;
    }

    //设计一个方法用来扩容
    private static Customer[] grow(Customer[] customers,int minCapacity){

        Customer[] newCustomer;
        int newCapacity = minCapacity + minCapacity >> 1;

        if (newCapacity < minCapacity){
            newCustomer= new Customer[minCapacity];
        }else {
            newCapacity = minCapacity;
            newCustomer = new Customer[newCapacity];
        }

        //将原数组中的内容复制到新数组中
        Customer[] customers1 = copyOf(customers,newCapacity);
        return customers1;
    }

    //设计一个方法将原数组中的内容复制到新数组中
    private static Customer[] copyOf(Customer[] customers,int capacity){
        Customer[] newCustomers = new Customer[capacity];
        for (int i = 0; i < customers.length;i++){
            newCustomers[i] = customers[i];
        }
        return newCustomers;
    }
}
