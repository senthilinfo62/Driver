package com.example.senthil.dirver1.Utilits;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gnanaprakash. S on 10/6/2016.
 */

public class FormValidator {
    public static boolean isValidUsername(String username) {
        CharSequence input_username = username;
        String validation_expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        Pattern pattern = Pattern.compile(validation_expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input_username);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        CharSequence input_password = password;
        String validation_expression = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d][A-Za-z\\d!@#$%^&*()_+]{6,12}$";

        Pattern pattern = Pattern.compile(validation_expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input_password);
        return matcher.matches();
    }
}


