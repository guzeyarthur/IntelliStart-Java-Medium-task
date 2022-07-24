package com.mediumTask.cache;

import com.mediumTask.constants.StringConstants;
import com.mediumTask.models.Product;
import com.mediumTask.models.User;
import com.mediumTask.validate.ValidateUser;

import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    public static ArrayList<User> users = new ArrayList<User>();

    public static void readAllUsers() {
        for (int i=0; i< users.size(); i++)
        {
            User user = users.get(i);
            System.out.println();
            System.out.println(user.toString());
        }
    }

    public static void buyProduct(Scanner scanner) {

        try {
            System.out.println(StringConstants.ENTER_USER_BY_ID);
            int idUser = Integer.valueOf(scanner.next());
            System.out.println(StringConstants.ENTER_PRODUCT_BY_ID);
            int idProduct = Integer.valueOf(scanner.next());
            for (int i = 0; i<users.size(); i++)
            {
                User user = users.get(i);
                if (idUser == user.getId())
                {
                    for (int j=0; j<Products.products.size();j++)
                    {
                        Product product = Products.products.get(j);
                        if (idProduct == product.getId())
                        {
                            user.buyProduct(product);
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(StringConstants.ERROR_COMMAND);
        }
    }

    public static void getUser(Scanner scanner){
        System.out.println(StringConstants.ENTER_FNAME);
        String fname = scanner.nextLine();
        System.out.println(StringConstants.ENTER_LNAME);
        String lname = scanner.nextLine();
        System.out.println(StringConstants.ENTER_AMOUNT);
        try {
            double amount = Double.valueOf(scanner.next());
            if (ValidateUser.checkUser(fname,lname,amount))
            {
                User user = new User(fname,lname,amount);
                Users.add(user);
            }
        } catch (NumberFormatException e) {
            System.out.println(StringConstants.ERROR_COMMAND);
        }

    }

    public static void deleteUserByID(Scanner scanner) {
        System.out.println(StringConstants.DELETE_USER_BY_ID);
        try {
            int id = Integer.valueOf(scanner.next());
            for (int i=0; i< users.size(); i++)
            {
                User user = users.get(i);
                if (user.getId() == id)
                {
                    delete(id);
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(StringConstants.ERROR_COMMAND);
        }
    }

    private static void add(User user) {
        System.out.println(StringConstants.SUCCESS_ADD_USER);
        users.add(user);
    }

    private static void delete (int userID) {
        System.out.println(StringConstants.SUCCESS_DELETE_USER);
        users.remove(userID);
    }
}
