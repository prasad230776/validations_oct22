package com.example.validations;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handlerMethod(Exception ex){
        Map<String, String> exInfo = new HashMap<>();
        exInfo.put("Default Exception", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exInfo);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handlerMethod(NoSuchElementException ex){
        Map<String, String> exInfo = new HashMap<>();
        exInfo.put("No Element Exception Occurred", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exInfo);
    }


    @ExceptionHandler(MyElementNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerMethod(MyElementNotFoundException ex){
        Map<String, String> exInfo = new HashMap<>();
        exInfo.put("Custom no element exception", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exInfo);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handlerMethod(MethodArgumentNotValidException ex){
        Map<String, String> exInfo = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e->
        //System.out.println(e.getField() + "   " + e.getDefaultMessage()));
        exInfo.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exInfo);
    }

   

}
