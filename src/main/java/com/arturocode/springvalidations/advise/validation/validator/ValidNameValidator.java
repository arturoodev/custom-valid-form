package com.arturocode.springvalidations.advise.validation.validator;

import com.arturocode.springvalidations.advise.validation.anotation.ValidName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {
    @Override
    public void initialize(ValidName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //Value cannot be null
        if (value == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("No debe ser null").addConstraintViolation();
            return false;
        }
        //Value cannot be empty
        else if (value.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("No puede estar vacio").addConstraintViolation();
            return false;

        }
        //Value cannot be greater than 15
        else if ((value.length() > 15)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("No debe ser mayor a 15 caracteres").addConstraintViolation();
            return false;

        }

        //Value cannot should have the first character in uppercase
        if (!Character.isUpperCase(value.charAt(0))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("La primera letra debe estar en mayuscula").addConstraintViolation();
            return false;

        } else {
            return true;
        }
    }
}
