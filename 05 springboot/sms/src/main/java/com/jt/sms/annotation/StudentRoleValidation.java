package com.jt.sms.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = StudentRoleValidator.class)
public @interface StudentRoleValidation {
    String message() default "Student role can only be either CR or GEN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
