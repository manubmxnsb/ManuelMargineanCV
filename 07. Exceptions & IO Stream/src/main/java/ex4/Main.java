package ex4;

import java.io.*;

public class Main {
    private String fileToStoreObject = "D:\\Scoala\\ISP\\30123_1_marginean_manuel_adrian_isp_labs\\Laborator7\\src\\main\\java\\ex4\\CarsDB.txt";

    public static void main(String[] args) {
        Main main = new Main();
        Car car = new Car("Panamera", 150_1000D);
        main.serializeCar(car);
        System.out.println("Object serialized: " + car);
        System.out.println("Deserialized opbject: " + main.deserializedCar());
    }

    private void serializeCar(Car car) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileToStoreObject))) {
            o.writeObject(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Car deserializedCar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileToStoreObject))) {
            return (Car) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}