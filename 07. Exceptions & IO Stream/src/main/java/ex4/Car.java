package ex4;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private String model;
    private double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }

}