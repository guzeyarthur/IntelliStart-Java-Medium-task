package com.mediumTask.validate;

import com.mediumTask.constants.StringConstants;

public class ValidateProduct {
    public static boolean checkProduct (String name, double price) {
        if (name == null || price<=0)
        {
            System.out.println(StringConstants.ERROR_COMMAND);
            return false;
        }
        return true;
    }
}
