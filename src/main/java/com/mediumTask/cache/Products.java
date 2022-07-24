package com.mediumTask.cache;

import com.mediumTask.constants.StringConstants;
import com.mediumTask.models.Product;
import com.mediumTask.models.User;
import com.mediumTask.validate.ValidateProduct;
import com.mediumTask.validate.ValidateUser;

import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    public static ArrayList<Product> products = new ArrayList<Product>();

    public static void readAllProducts() {
        for (int i=0; i< products.size(); i++)
        {
            Product product = products.get(i);
            System.out.println();
            System.out.println(product.toString());
        }
    }

    public static void getProduct(Scanner scanner){
        System.out.println(StringConstants.ENTER_NAME);
        String name = scanner.nextLine();
        System.out.println(StringConstants.ENTER_PRICE);
        try {
            double price = Double.valueOf(scanner.next());
            if (ValidateProduct.checkProduct(name,price))
            {
                Product product = new Product(name, price);
                Products.add(product);
            }
        } catch (NumberFormatException e) {
            System.out.println(StringConstants.ERROR_COMMAND);
        }
    }

    public static void deleteProductByID(Scanner scanner) {
        System.out.println(StringConstants.DELETE_PRODUCT_BY_ID);
        try {
            int id = Integer.valueOf(scanner.next());
            for (int i=0; i< products.size(); i++)
            {
                Product product = products.get(i);
                if (product.getId() == id)
                {
                    delete(id);
                    deleteProductInAllUsers(id);
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(StringConstants.ERROR_COMMAND);
        }
    }

    private static void add(Product product) {
        System.out.println(StringConstants.SUCCESS_ADD_PRODUCT);
        products.add(product);
    }

    private static void delete (int productID) {
        System.out.println(StringConstants.SUCCESS_DELETE_PRODUCT);
        products.remove(productID);
    }

    private static void deleteProductInAllUsers(int id)
    {
        for (int i=0; i<Users.users.size(); i++)
        {
            User user = Users.users.get(i);
            for (int j=0; j<user.products.size();j++)
            {
                if (id == user.products.get(j).getId())
                {
                    user.products.remove(j);
                }
            }
        }
    }

}
