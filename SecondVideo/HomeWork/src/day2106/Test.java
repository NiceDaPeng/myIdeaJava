package day2106;

public class Test {

    public static void main(String[] args) {
        Coordinate<String> cor = new Coordinate<>();
        cor.setX("厉害了");
        cor.setY("很厉害");
        System.out.println(cor);
        Coordinate<Double> coo = new Coordinate<>();
        coo.setX(21.9);
        coo.setY(22.3);
        System.out.println(coo);
    }
}
