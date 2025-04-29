package com.sa.spring_tuto_web.rest_controllers;

import com.sa.spring_tuto_web.dto.TeacherDTO;
import com.sa.spring_tuto_web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TeacherDTO> getTeachers() {
        return teacherService.getAllTeachers();
    }
}