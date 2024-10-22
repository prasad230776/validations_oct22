package com.example.validations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    Integer id;
    @Size(min=5, max=25, message = "Name must be having chars between 5 and 25")
    String name;
    @Email(message = "Invalid email")
    String email;
    @Min(value=15, message = "Min gae is 25")
    @Max(value = 65, message="Max age limit is 65")
    Integer age;
}
