package com.book.booksstore.validator;

import com.book.booksstore.dto.CreateUserRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import org.springframework.beans.BeanWrapperImpl;

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
        Object field = new BeanWrapperImpl(dto).getPropertyValue(this.field);
        Object fieldMatch = new BeanWrapperImpl(dto).getPropertyValue(this.fieldMatch);
        return Objects.equals(field, fieldMatch);
    }
}