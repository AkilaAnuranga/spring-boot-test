package com.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> students(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Student> store(@RequestBody Student student){

        Student save = repository.save(student);
        return ResponseEntity.ok().body(save);

    }
}
