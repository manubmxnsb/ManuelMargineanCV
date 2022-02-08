package Ex5_Flower;

public class TestFlower {
    public static void main(String[] args) {
        Flower f1 = new Flower(1);
        Flower f2 = new Flower(2);
        Flower f3 = new Flower(3);
        System.out.println("Total number of flowers is " + Flower.getNoOfObjects());
    }

}
