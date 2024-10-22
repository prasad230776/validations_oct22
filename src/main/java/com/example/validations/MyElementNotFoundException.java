package com.example.validations;

public class MyElementNotFoundException extends RuntimeException {
    MyElementNotFoundException(String mesage){
        super(mesage);
    }
}
