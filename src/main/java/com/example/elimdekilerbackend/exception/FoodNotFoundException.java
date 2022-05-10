package com.example.elimdekilerbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class FoodNotFoundException extends RuntimeException{
    private String foodName;
    private String fieldName;
    private Object fieldValue;

    public FoodNotFoundException(String foodName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", foodName, fieldName, fieldValue));
        this.foodName = foodName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
