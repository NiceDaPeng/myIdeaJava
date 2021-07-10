package dpj.testthread;

public class ThreadDemo1 implements Runnable{

    private String id;

    public ThreadDemo1(){}

    public ThreadDemo1(String id){
       this.id = id;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public void run() {
        System.out.println(this.getId() + "开始执行");
    }
}
