package project.model.utils;

import project.controller.exception.ValidationException;

import java.util.regex.Pattern;

public class Validator {
    private static Validator validator = new Validator();

    private Validator() {
    }

    public static Validator getValidator() {
        return validator;
    }

    public String nameValidator(String name, String message) throws ValidationException {
        if (Pattern.matches("", name)){
            return name;
        }else{
            throw new ValidationException(message);
        }
    }
}
