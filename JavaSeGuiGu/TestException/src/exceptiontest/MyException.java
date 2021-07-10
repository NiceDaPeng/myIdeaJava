package exceptiontest;

public class MyException extends RuntimeException{

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}
