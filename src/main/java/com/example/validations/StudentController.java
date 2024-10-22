package com.example.validations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentRepository.save(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id){
        // return new ResponseEntity<>(studentRepository.findById(id).get(), HttpStatus.OK);
        Optional<Student> opStudent = studentRepository.findById(id);
        Student student = opStudent.orElseThrow(()->new MyElementNotFoundException("Student not found with id: " + id));
        return ResponseEntity.ok(student);
    }

}
