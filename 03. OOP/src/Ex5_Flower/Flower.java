package Ex5_Flower;

public class Flower {
    private int petal;
    private static int noOfObjects = 0;

    public Flower(int p) {
        petal = p;
        noOfObjects += 1;
        System.out.println("New flower has been created!");

    }

    public static int getNoOfObjects() {
        return noOfObjects;
    }
}