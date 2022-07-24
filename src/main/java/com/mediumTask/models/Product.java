package com.mediumTask.models;

public class Product {
    private static int autoId = 0;
    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        id = autoId;
        this.name = name;
        this.price = price;
        autoId++;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
