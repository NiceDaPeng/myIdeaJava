package dpj.testthread;

public class Windows extends Thread {

    private String aname;

    public Windows(){}

    public Windows(String aname){
        this.aname = aname;
    }

    public void setAname(String aname){
        this.aname = aname;
    }

    public String getAname(){
        return this.aname;
    }

    public void run(){
        for (int i = 0; i < 10; i++){

            System.out.println(this.getName()+"卖出去了1张票");
        }
    }
}
