package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student add(Student student) {
        Optional<Student> theStudent = studentRepository.findStudentByEmail(student.getEmail());

        if (theStudent.isPresent()) {
            throw new IllegalStateException("Email already exist.");
        }

        return studentRepository.save(student);
    }

    @Transactional
    public Student edit(Student student) {
        Optional<Student> theStudent = studentRepository.findById(student.getId());
        if (theStudent.isEmpty()) {
            throw new IllegalStateException("The Student is not exist.");
        }
        return studentRepository.save(student);
    }

    @Transactional
    public void delete(Integer id) {
        Optional<Student> theStudent = studentRepository.findById(id);
        if (theStudent.isEmpty()) {
            throw new IllegalStateException("The Student is not exist.");
        }
        studentRepository.deleteById(id);
    }
}
