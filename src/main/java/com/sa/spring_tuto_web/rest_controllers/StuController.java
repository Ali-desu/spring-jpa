package com.sa.spring_tuto_web.rest_controllers;

import com.sa.spring_tuto_web.dto.StudentDTO;
import com.sa.spring_tuto_web.mapper.StudentMapper;
import com.sa.spring_tuto_web.model.Student;
import com.sa.spring_tuto_web.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StuController {
    private final StudentService studentService;

    public StuController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Map<String, String> getMessage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from the API!");
        return response;
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/{start}/{end}")
    public List<Student> getStudentsByMark(@PathVariable("start") double start, @PathVariable("end") double end) {
        return studentService.findByMarkBetween(start, end);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

    @PutMapping("/students/{id}")
    public Map<String, String> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        Map<String, String> response = new HashMap<>();
        boolean updated = studentService.updateStudent(id, student);
        response.put("message", updated ? "Student updated" : "Student not found");
        return response;
    }

    @DeleteMapping("/students/{id}")
    public Map<String, String> deleteStudent(@PathVariable("id") Long id) {
        Map<String, String> response = new HashMap<>();
        boolean deleted = studentService.deleteStudent(id);
        response.put("message", deleted ? "Student deleted" : "Student not found");
        return response;
    }

    @PostMapping("/students/{studentId}/modules/{moduleId}")
    public Map<String, String> enrollStudentInModule(
            @PathVariable("studentId") Long studentId,
            @PathVariable("moduleId") Long moduleId
    ) {
        Map<String, String> response = new HashMap<>();
        boolean enrolled = studentService.enrollStudentInModule(studentId, moduleId);
        response.put("message", enrolled ? "Student enrolled in module" : "Enrollment failed");
        return response;
    }
}