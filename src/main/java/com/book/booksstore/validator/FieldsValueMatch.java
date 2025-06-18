package com.book.booksstore.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {
    String message() default "Password and Repeat Password do not match";

    String field() default "password";

    String fieldMatch() default "repeatPassword";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
