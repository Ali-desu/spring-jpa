package com.sa.spring_tuto_web.rest_controllers;

import com.sa.spring_tuto_web.dto.TeacherDTO;
import com.sa.spring_tuto_web.model.Teacher;
import com.sa.spring_tuto_web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins = "*")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherDTO> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return teacher;
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        teacherService.updateTeacher(teacher);
        return teacher;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteTeacher(@PathVariable("id") Long id) {
        Map<String, String> response = new HashMap<>();
        teacherService.deleteTeacherById(id);
        response.put("message", "Teacher deleted");
        return response;
    }
}