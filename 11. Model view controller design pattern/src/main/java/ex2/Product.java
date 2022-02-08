package exercises.ex2;

public class Product {
    // product is the model from MVC design pattern

    private String name;
    private int quantity;
    private double price;

    public Product(String productName, int qty, double currentPrice) {
        this.name = productName;
        this.price = currentPrice;
        this.quantity = qty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product:  " +
                name +
                ", quantity=" + quantity +
                ", price=" + price;
    }
}
