package factorydesignmode;

public class Test {

    public static void main(String[] args) {
        Aodi aodi = (Aodi) Factory.getInstance("factorydesignmode.Aodi");
        aodi.run();
    }
}
