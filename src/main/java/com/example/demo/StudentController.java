package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }


    @PutMapping
    public Student edit(@RequestBody Student student) {
        return studentService.edit(student);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}
