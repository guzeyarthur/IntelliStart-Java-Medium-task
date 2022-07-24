import com.mediumTask.cache.Products;
import com.mediumTask.cache.Users;
import com.mediumTask.constants.StringConstants;

import java.util.Scanner;

public class StartApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StartApp startApp = new StartApp();
        startApp.start();
    }

    private void start(){
        System.out.println(StringConstants.HELLO);

        while (true) {
            System.out.println(StringConstants.SELECT_COMMAND);
            String command = scanner.nextLine();
            selectCommand(command);
        }
    }

    private void selectCommand(String command){
        switch (command) {
            case (StringConstants.CREATE_USER):
                Users.getUser(scanner);
                break;
            case (StringConstants.CREATE_PRODUCT):
                Products.getProduct(scanner);
                break;
            case (StringConstants.READ_USERS):
                Users.readAllUsers();
                break;
            case (StringConstants.READ_PRODUCTS):
                Products.readAllProducts();
                break;
            case (StringConstants.DELETE_USER):
                Users.deleteUserByID(scanner);
                break;
            case (StringConstants.DELETE_PRODUCT):
                Products.deleteProductByID(scanner);
                break;
            case (StringConstants.BUY):
                Users.buyProduct(scanner);
                break;

            case (StringConstants.EXIT):
                exitApp();
            default:
                System.out.println(StringConstants.ERROR_COMMAND);
                break;
        }
    }

    private void exitApp(){
        System.out.println(StringConstants.GOOD_BYE);
        System.exit(0);
    }


}
