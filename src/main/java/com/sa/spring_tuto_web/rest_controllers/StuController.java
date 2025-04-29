package com.sa.spring_tuto_web.rest_controllers;

import com.sa.spring_tuto_web.dto.StudentDTO;
import com.sa.spring_tuto_web.model.Student;
import com.sa.spring_tuto_web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// UserController handles HTTP requests related to users
@RestController
@RequestMapping("/api")  // Base URL for all methods in this controller
public class StuController {
    // Injecting the StudentService to handle business logic

    private final StudentService studentService;

    //constructor
    public StuController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handles GET requests to /api and returns a list of users
    @GetMapping
    public Map<String, String> getMessage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from the API!");
        return response;
    }

    // Handles GET requests to /api/students and returns a list of students

//    public Map<String, List<StudentDTO>> getStudents() {
//        Map<String, List<StudentDTO>> response = new HashMap<>();
//        response.put("students", studentService.getAllStudents());
//        return response;
//    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }

    // Handles GET requests to /api/students/{id} and returns a specific student
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/{start}/{end}")
    public List<Student> getStudentsByMark(@PathVariable("start") double start, @PathVariable("end") double end ) {
        return studentService.findByMarkBetween(start,end);
    }
}