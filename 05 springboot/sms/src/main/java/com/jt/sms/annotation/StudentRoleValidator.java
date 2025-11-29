package com.jt.sms.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class StudentRoleValidator implements ConstraintValidator<StudentRoleValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) return false;

        List<String> roles = List.of("GEN", "CR");
        return roles.contains(value);
    }
}
