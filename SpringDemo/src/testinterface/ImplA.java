package testinterface;

public class ImplA implements TestInterface{
    @Override
    public void interfaceMethod() {
        System.out.println("实现类A重写的方法");
    }
}
