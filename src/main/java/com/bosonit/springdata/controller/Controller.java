package com.bosonit.springdata.controller;

import com.bosonit.springdata.domain.Student;
import com.bosonit.springdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Controller {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @DeleteMapping
    public void deleteStudentById(@RequestParam int id) {
        studentRepository.deleteById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id) {
        studentRepository.findById(id).orElseThrow();
        return studentRepository.save(student);
    }

}
