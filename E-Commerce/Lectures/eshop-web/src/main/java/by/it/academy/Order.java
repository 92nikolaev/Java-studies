package by.it.academy;

public class Order {

    private String productName;
    private int quantity;
    private double price;
    private double total = 0;

    public Order() {
    }

    public Order(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        total = price * quantity;
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
