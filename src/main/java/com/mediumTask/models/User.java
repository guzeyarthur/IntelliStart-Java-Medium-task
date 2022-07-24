package com.mediumTask.models;

import com.mediumTask.constants.StringConstants;

import java.util.ArrayList;

public class User {
    private static int autoId = 0;
    private int id;
    private String FirstName;
    private String LastName;
    private double amount;
    public ArrayList<Product> products = new ArrayList<>();

    public int getId() {
        return id;
    }


    public User(String firstName, String lastName, double amount) {
        id = autoId;
        FirstName = firstName;
        LastName = lastName;
        this.amount = amount;
        autoId++;
    }

    public void buyProduct(Product product){
        if (product.getPrice()>amount) {
            System.out.println(StringConstants.ERROR_AMOUNT);
        } else {
            System.out.println(StringConstants.SUCCESS_BUY);
            products.add(product);
            amount -= product.getPrice();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", amount=" + amount +
                ", products=" + products +
                '}';
    }
}
