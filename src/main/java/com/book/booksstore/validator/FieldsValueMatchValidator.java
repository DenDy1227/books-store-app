package com.book.booksstore.validator;

import com.book.booksstore.dto.CreateUserRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldsValueMatchValidator implements
        ConstraintValidator<FieldsValueMatch, CreateUserRequestDto> {
    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(CreateUserRequestDto dto,
                           ConstraintValidatorContext context) {
        if (dto.getPassword() == null || dto.getRepeatPassword() == null) {
            return false;
        }

        boolean matches = dto.getPassword().equals(dto.getRepeatPassword());
        if (!matches) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("repeatPassword")
                    .addConstraintViolation();
        }
        return matches;
    }
}