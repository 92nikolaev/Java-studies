package com.gmail.slshukevitch.project;

public class Order {
    private String productName;
    private int quantity;
    private double price;
    private double total;



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
        total = price*quantity;
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
