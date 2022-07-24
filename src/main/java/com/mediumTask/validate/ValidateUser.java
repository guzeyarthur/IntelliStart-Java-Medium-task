package com.mediumTask.validate;

import com.mediumTask.constants.StringConstants;
import com.mediumTask.models.User;

public class ValidateUser {
    public static boolean checkUser(String firstName, String lastName, double amount) {
        if (firstName==null || lastName==null || amount<=0)
        {
            System.out.println(StringConstants.ERROR_COMMAND);
            return false;
        }
        return true;
    }
}
