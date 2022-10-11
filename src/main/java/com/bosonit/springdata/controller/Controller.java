package com.bosonit.springdata.controller;

import com.bosonit.springdata.domain.Student;
import com.bosonit.springdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/student")
public class Controller {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        URI location = URI.create("/student");
        return ResponseEntity.created(location).body(studentRepository.save(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(studentRepository.findById(id).orElseThrow());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudentById(@RequestParam int id) {
        try {
            studentRepository.findById(id).orElseThrow();
            studentRepository.deleteById(id);
            return ResponseEntity.ok().body("student with id: "+id+" was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<Student> getAllStudents(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent();
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        try {
            studentRepository.findById(student.getId()).orElseThrow();
            return  ResponseEntity.ok().body(studentRepository.save(student));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
